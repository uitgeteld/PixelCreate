package xyz.uitgeteld.pixelcreate.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import xyz.uitgeteld.pixelcreate.PixelCreate;
import xyz.uitgeteld.pixelcreate.fluid.FluidRegistrationHelper;
import xyz.uitgeteld.pixelcreate.fluid.ModFluidTypes;
import xyz.uitgeteld.pixelcreate.fluid.ModFluids;

@EventBusSubscriber(modid = PixelCreate.MODID, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModFluids.MOLTEN_IRON.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.MOLTEN_IRON_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.MOLTEN_ALUMINUM.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.MOLTEN_ALUMINUM_FLOWING.get(), RenderType.translucent());
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(
                FluidRegistrationHelper.createClientExtensions("molten_iron"),
                ModFluidTypes.MOLTEN_IRON_TYPE.get());

        event.registerFluidType(
                FluidRegistrationHelper.createClientExtensions("molten_aluminum"),
                ModFluidTypes.MOLTEN_ALUMINUM_TYPE.get());
    }
}