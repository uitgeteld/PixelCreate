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

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> MOLTEN_IRON_FLOWING =
            FLUIDS.register("molten_iron_flowing",
                    () -> new BaseFlowingFluid.Flowing(getMoltenIronProperties()));

    private static BaseFlowingFluid.Properties getMoltenIronProperties() {
        return new BaseFlowingFluid.Properties(
                ModFluidTypes.MOLTEN_IRON_TYPE,
                MOLTEN_IRON,
                MOLTEN_IRON_FLOWING)
                .block(() -> (LiquidBlock) ModBlocks.MOLTEN_IRON_BLOCK.get())
                .bucket(ModItems.MOLTEN_IRON_BUCKET)
                .tickRate(30)
                .slopeFindDistance(2)
                .levelDecreasePerBlock(2)
                .explosionResistance(1000f);
    }
}