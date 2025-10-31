package xyz.uitgeteld.pixelcreate.tab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.uitgeteld.pixelcreate.PixelCreate;
import xyz.uitgeteld.pixelcreate.block.ModBlocks;
import xyz.uitgeteld.pixelcreate.item.ModItems;
import xyz.uitgeteld.pixelcreate.item.pokeball.AncientPokeballs;
import xyz.uitgeteld.pixelcreate.item.pokeball.NormalPokeballs;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PixelCreate.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB =
            CREATIVE_MODE_TABS.register("pixelcreate", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.pixelcreate")) // name key
                    .withTabsBefore(CreativeModeTabs.COMBAT) // where it shows in the menu
                    .icon(() -> ModItems.ALUMINUM_SHEET.get().getDefaultInstance()) // tab icon
                    .displayItems((parameters, output) -> {
                        // Materials
                        output.accept(ModItems.ALUMINUM_SHEET.get());
                        output.accept(ModItems.PLATINUM_SHEET.get());
                        output.accept(ModItems.SILVER_SHEET.get());
                        output.accept(ModItems.WOODEN_SHEET.get());

                        // Chunks
                        output.accept(ModItems.DEEPSLATE_CHUNK.get());
                        output.accept(ModItems.RAW_IRON_CHUNK.get());
                        output.accept(ModItems.RAW_COPPER_CHUNK.get());
                        output.accept(ModItems.RAW_ZINC_CHUNK.get());
                        output.accept(ModItems.RAW_BAUXITE_CHUNK.get());
                        output.accept(ModItems.RAW_GOLD_CHUNK.get());
                        output.accept(ModItems.RAW_SILVER_CHUNK.get());
                        output.accept(ModItems.RAW_PLATINUM_CHUNK.get());

                        output.accept(ModItems.MOLTEN_IRON_BUCKET.get());

                        // Normal Pokéballs
                        output.accept(NormalPokeballs.INCOMPLETE_POKE_BALL.get());
                        output.accept(NormalPokeballs.INCOMPLETE_GREAT_BALL.get());
                        output.accept(NormalPokeballs.INCOMPLETE_ULTRA_BALL.get());

                        // Ancient Pokéballs
                        output.accept(AncientPokeballs.INCOMPLETE_ANCIENT_POKE_BALL.get());
                        output.accept(AncientPokeballs.INCOMPLETE_ANCIENT_GREAT_BALL.get());
                        output.accept(AncientPokeballs.INCOMPLETE_ANCIENT_ULTRA_BALL.get());
                    }).build());
}
