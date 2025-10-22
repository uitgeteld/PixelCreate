package xyz.uitgeteld.pixelcreate.fluid;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

import static xyz.uitgeteld.pixelcreate.PixelCreate.MODID;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, MODID);

    public static final DeferredHolder<FluidType, FluidType> RAW_IRON_MOLTEN_TYPE =
            FLUID_TYPES.register("raw_iron_molten",
                    () -> new FluidType(FluidType.Properties.create()
                            .density(3000)
                            .viscosity(6000)
                            .motionScale(0.007)
                            .lightLevel(15)
                            .canConvertToSource(false)
                    ));
}