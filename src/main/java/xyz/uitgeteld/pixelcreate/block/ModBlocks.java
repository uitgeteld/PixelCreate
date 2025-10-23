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

    public static final DeferredHolder<Block, LiquidBlock> RAW_IRON_MOLTEN_BLOCK =
            BLOCKS.register("raw_iron_molten_block",
                    () -> new LiquidBlock(ModFluids.RAW_IRON_MOLTEN_SOURCE.get(),
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_BROWN)
                                    .noCollission()
                                    .strength(100.0F, 100.0F)
                                    .lightLevel((state) -> 15)
                                    .noLootTable()
                                    .replaceable()));
}