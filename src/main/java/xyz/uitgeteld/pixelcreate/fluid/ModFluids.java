package xyz.uitgeteld.pixelcreate.fluid;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import xyz.uitgeteld.pixelcreate.block.ModBlocks;
import xyz.uitgeteld.pixelcreate.item.ModItems;

import static xyz.uitgeteld.pixelcreate.PixelCreate.MODID;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, MODID);

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> RAW_IRON_MOLTEN_SOURCE =
            FLUIDS.register("raw_iron_molten_source",
                    () -> new BaseFlowingFluid.Source(getRawIronMoltenProperties()));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> RAW_IRON_MOLTEN_FLOWING =
            FLUIDS.register("raw_iron_molten_flowing",
                    () -> new BaseFlowingFluid.Flowing(getRawIronMoltenProperties()));

    private static BaseFlowingFluid.Properties getRawIronMoltenProperties() {
        return new BaseFlowingFluid.Properties(
                ModFluidTypes.RAW_IRON_MOLTEN_TYPE,
                RAW_IRON_MOLTEN_SOURCE,
                RAW_IRON_MOLTEN_FLOWING)
                .block(() -> (LiquidBlock) ModBlocks.RAW_IRON_MOLTEN_BLOCK.get())
                .bucket(ModItems.RAW_IRON_MOLTEN_BUCKET)
                .tickRate(30)
                .slopeFindDistance(2)
                .levelDecreasePerBlock(2)
                .explosionResistance(1000f);
    }
}