package xyz.uitgeteld.pixelcreate.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import xyz.uitgeteld.pixelcreate.PixelCreate;

import java.util.function.Supplier;

public class FluidRegistrationHelper {
    
    public static FluidType.Properties createMoltenFluidTypeProperties() {
        return FluidType.Properties.create()
                .density(3000)
                .viscosity(6000)
                .motionScale(0.007)
                .lightLevel(15)
                .canConvertToSource(false);
    }
    
    /**
     * @param density The fluid density
     * @param viscosity The fluid viscosity
     * @param lightLevel The light level (0-15)
     * @return FluidType.Properties configured for a molten metal
     */
    public static FluidType.Properties createMoltenFluidTypeProperties(int density, int viscosity, int lightLevel) {
        return FluidType.Properties.create()
                .density(density)
                .viscosity(viscosity)
                .motionScale(0.007)
                .lightLevel(lightLevel)
                .canConvertToSource(false);
    }
    
    /**
     * @param fluidType The fluid type holder
     * @param source The source fluid holder
     * @param flowing The flowing fluid holder
     * @param block The liquid block supplier
     * @param bucket The bucket holder
     * @return BaseFlowingFluid.Properties configured for a molten metal
     */
    public static BaseFlowingFluid.Properties createMoltenFluidProperties(
            DeferredHolder<FluidType, FluidType> fluidType,
            Supplier<? extends BaseFlowingFluid.Source> source,
            Supplier<? extends BaseFlowingFluid.Flowing> flowing,
            Supplier<?> block,
            Supplier<?> bucket) {
        return new BaseFlowingFluid.Properties(fluidType, source, flowing)
                .block((Supplier<? extends LiquidBlock>) block)
                .bucket((Supplier<? extends Item>) bucket)
                .tickRate(30)
                .slopeFindDistance(2)
                .levelDecreasePerBlock(2)
                .explosionResistance(1000f);
    }
    
    /**
     * @param lightLevel The light level (0-15)
     * @return BlockBehaviour.Properties configured for a molten metal fluid block
     */
    public static BlockBehaviour.Properties createMoltenFluidBlockProperties(int lightLevel) {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_BROWN)
                .noCollission()
                .strength(100.0F, 100.0F)
                .lightLevel((state) -> lightLevel)
                .noLootTable()
                .replaceable();
    }
    
    /**
     * @param mapColor The map color
     * @param lightLevel The light level (0-15)
     * @return BlockBehaviour.Properties configured for a molten metal fluid block
     */
    public static BlockBehaviour.Properties createMoltenFluidBlockProperties(MapColor mapColor, int lightLevel) {
        return BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .noCollission()
                .strength(100.0F, 100.0F)
                .lightLevel((state) -> lightLevel)
                .noLootTable()
                .replaceable();
    }
    
    /**
     * @param name The base name for the fluid (e.g., "molten_iron")
     * @return IClientFluidTypeExtensions for registration
     */
    public static IClientFluidTypeExtensions createClientExtensions(String name) {
        return new IClientFluidTypeExtensions() {
            private final ResourceLocation STILL = ResourceLocation.fromNamespaceAndPath(
                    PixelCreate.MODID, "block/" + name);
            private final ResourceLocation FLOWING = ResourceLocation.fromNamespaceAndPath(
                    PixelCreate.MODID, "block/" + name + "_flowing");

            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return STILL;
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return FLOWING;
            }
        };
    }
}
