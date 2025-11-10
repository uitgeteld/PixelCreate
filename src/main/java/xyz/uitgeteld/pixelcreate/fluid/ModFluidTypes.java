package xyz.uitgeteld.pixelcreate.fluid;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

import static xyz.uitgeteld.pixelcreate.PixelCreate.MODID;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, MODID);

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_IRON_TYPE =
            FLUID_TYPES.register("molten_iron",
                    () -> new FluidType(FluidRegistrationHelper.createMoltenFluidTypeProperties()));

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_ALUMINUM_TYPE =
            FLUID_TYPES.register("molten_aluminum",
                    () -> new FluidType(FluidRegistrationHelper.createMoltenFluidTypeProperties()));
}