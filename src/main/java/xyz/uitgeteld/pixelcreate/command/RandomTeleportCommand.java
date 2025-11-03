package xyz.uitgeteld.pixelcreate.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class RandomTeleportCommand {
    private static final Random RANDOM = new Random();
    private static final int RANGE = 5000;
    private static final long COOLDOWN_MS = 2 * 60 * 1000;

    private static final Map<UUID, Long> COOLDOWNS = new HashMap<>();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("rtp")
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayerOrException();
                            ServerLevel level = player.serverLevel();

                            if (level.dimension() != Level.OVERWORLD) {
                                player.sendSystemMessage(Component.literal("§c/rtp can only be used in the Overworld!"));
                                return 0;
                            }

                            long now = System.currentTimeMillis();

                            if (COOLDOWNS.containsKey(player.getUUID())) {
                                long lastUsed = COOLDOWNS.get(player.getUUID());
                                long timeLeft = (COOLDOWN_MS - (now - lastUsed)) / 1000;
                                if (timeLeft > 0) {
                                    player.sendSystemMessage(Component.literal("§cYou must wait " + timeLeft + " seconds before using /rtp again!"));
                                    return 0;
                                }
                            }

                            double x = RANDOM.nextInt(RANGE * 2) - RANGE;
                            double z = RANDOM.nextInt(RANGE * 2) - RANGE;

                            BlockPos pos = findSafePos(level, new BlockPos((int) x, 0, (int) z));

                            if (pos == null) {
                                player.sendSystemMessage(Component.literal("§cFailed to find a safe spot. Try again!"));
                                return 0;
                            }

                            player.teleportTo(level, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, player.getYRot(), player.getXRot());
                            player.sendSystemMessage(Component.literal("§aTeleported to random location: §7X: " + pos.getX() + " Y: " + pos.getY() + " Z: " + pos.getZ()));

                            COOLDOWNS.put(player.getUUID(), now);
                            return 1;
                        })
        );
    }

    private static BlockPos findSafePos(ServerLevel level, BlockPos startPos) {
        BlockPos topPos = level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING,
                new BlockPos(startPos.getX(), 0, startPos.getZ()));

        BlockState groundBlock = level.getBlockState(topPos.below());
        BlockState feetBlock = level.getBlockState(topPos);
        BlockState headBlock = level.getBlockState(topPos.above());

        if (feetBlock.isAir() && headBlock.isAir() &&
                groundBlock.isSolid() &&
                !isUnsafeBlock(groundBlock)) {
            return topPos.below();
        }

        return null;
    }

    private static boolean isUnsafeBlock(BlockState state) {
        return !state.getFluidState().isEmpty() ||
                state.is(Blocks.CACTUS) ||
                state.is(Blocks.FIRE) ||
                state.is(Blocks.MAGMA_BLOCK);
    }
}
