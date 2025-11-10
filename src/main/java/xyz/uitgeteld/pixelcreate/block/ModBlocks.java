package xyz.uitgeteld.pixelcreate.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import xyz.uitgeteld.pixelcreate.fluid.ModFluids;

import static xyz.uitgeteld.pixelcreate.PixelCreate.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, MODID);

    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_IRON_BLOCK =
            BLOCKS.register("molten_iron_block",
                    () -> new LiquidBlock(ModFluids.MOLTEN_IRON.get(),
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_BROWN)
                                    .noCollission()
                                    .strength(100.0F, 100.0F)
                                    .lightLevel((state) -> 15)
                                    .noLootTable()
                                    .replaceable()));

    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_ALUMINUM_BLOCK =
            BLOCKS.register("molten_aluminum_block",
                    () -> new LiquidBlock(ModFluids.MOLTEN_ALUMINUM.get(),
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_BROWN)
                                    .noCollission()
                                    .strength(100.0F, 100.0F)
                                    .lightLevel((state) -> 15)
                                    .noLootTable()
                                    .replaceable()));
}