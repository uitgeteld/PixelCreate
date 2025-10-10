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

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class RandomTeleportCommand {
    private static final Random RANDOM = new Random();
    private static final int RANGE = 5000; // how far the teleport can go
    private static final long COOLDOWN_MS = 5 * 60 * 1000; // 5 minutes

    private static final Map<UUID, Long> COOLDOWNS = new HashMap<>();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("rtp")
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayerOrException();
                            long now = System.currentTimeMillis();

                            // Check cooldown
                            if (COOLDOWNS.containsKey(player.getUUID())) {
                                long lastUsed = COOLDOWNS.get(player.getUUID());
                                long timeLeft = (COOLDOWN_MS - (now - lastUsed)) / 1000;
                                if (timeLeft > 0) {
                                    player.sendSystemMessage(Component.literal("§cYou must wait " + timeLeft + " seconds before using /rtp again!"));
                                    return 0;
                                }
                            }

                            ServerLevel level = player.serverLevel();
                            double x = RANDOM.nextInt(RANGE * 2) - RANGE;
                            double z = RANDOM.nextInt(RANGE * 2) - RANGE;

                            // Find safe Y position
                            BlockPos pos = findSafePos(level, new BlockPos((int)x, level.getMaxBuildHeight(), (int)z));

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

    private static BlockPos findSafePos(Level level, BlockPos startPos) {
        // Scan downward until we find solid ground with air above
        for (int y = level.getMaxBuildHeight(); y > level.getMinBuildHeight(); y--) {
            BlockPos pos = new BlockPos(startPos.getX(), y, startPos.getZ());
            BlockState block = level.getBlockState(pos);
            BlockState above = level.getBlockState(pos.above());
            if (block.isSolid() && above.isAir()) {
                return pos;
            }
        }
        return null;
    }
}
