package xyz.uitgeteld.pixelcreate.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import xyz.uitgeteld.pixelcreate.PixelCreate;
import xyz.uitgeteld.pixelcreate.fluid.ModFluidTypes;
import xyz.uitgeteld.pixelcreate.fluid.ModFluids;

@EventBusSubscriber(modid = PixelCreate.MODID, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModFluids.RAW_IRON_MOLTEN_SOURCE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.RAW_IRON_MOLTEN_FLOWING.get(), RenderType.translucent());
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            private static final ResourceLocation STILL = ResourceLocation.withDefaultNamespace("block/lava_still");
            private static final ResourceLocation FLOWING = ResourceLocation.withDefaultNamespace("block/lava_flow");
            private static final ResourceLocation OVERLAY = ResourceLocation.withDefaultNamespace("block/lava_flow");

            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return STILL;
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return FLOWING;
            }

            @Override
            public ResourceLocation getOverlayTexture() {
                return OVERLAY;
            }

            @Override
            public int getTintColor() {
                return 0xFFFF5500;
            }
        }, ModFluidTypes.RAW_IRON_MOLTEN_TYPE.get());
    }
}