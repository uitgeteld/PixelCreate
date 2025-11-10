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

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> MOLTEN_IRON =
            FLUIDS.register("molten_iron",
                    () -> new BaseFlowingFluid.Source(getMoltenIronProperties()));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> MOLTEN_ALUMINUM =
            FLUIDS.register("molten_aluminum",
                    () -> new BaseFlowingFluid.Source(getMoltenAluminumProperties()));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> MOLTEN_IRON_FLOWING =
            FLUIDS.register("molten_iron_flowing",
                    () -> new BaseFlowingFluid.Flowing(getMoltenIronProperties()));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> MOLTEN_ALUMINUM_FLOWING =
            FLUIDS.register("molten_aluminum_flowing",
                    () -> new BaseFlowingFluid.Flowing(getMoltenAluminumProperties()));

    private static BaseFlowingFluid.Properties getMoltenIronProperties() {
        return FluidRegistrationHelper.createMoltenFluidProperties(
                ModFluidTypes.MOLTEN_IRON_TYPE,
                MOLTEN_IRON,
                MOLTEN_IRON_FLOWING,
                () -> (LiquidBlock) ModBlocks.MOLTEN_IRON_BLOCK.get(),
                ModItems.MOLTEN_IRON_BUCKET
        );
    }

    private static BaseFlowingFluid.Properties getMoltenAluminumProperties() {
        return FluidRegistrationHelper.createMoltenFluidProperties(
                ModFluidTypes.MOLTEN_ALUMINUM_TYPE,
                MOLTEN_ALUMINUM,
                MOLTEN_ALUMINUM_FLOWING,
                () -> (LiquidBlock) ModBlocks.MOLTEN_ALUMINUM_BLOCK.get(),
                ModItems.MOLTEN_ALUMINUM_BUCKET
        );
    }
}