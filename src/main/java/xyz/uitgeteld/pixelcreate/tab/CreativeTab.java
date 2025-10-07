package xyz.uitgeteld.pixelcreate.tab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.uitgeteld.pixelcreate.PixelCreate;
import xyz.uitgeteld.pixelcreate.item.material.MaterialItems;
import xyz.uitgeteld.pixelcreate.item.pokeball.AncientPokeballs;
import xyz.uitgeteld.pixelcreate.item.pokeball.NormalPokeballs;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PixelCreate.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB =
            CREATIVE_MODE_TABS.register("pixelcreate", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.pixelcreate")) // name key
                    .withTabsBefore(CreativeModeTabs.COMBAT) // where it shows in the menu
                    .icon(() -> MaterialItems.ALUMINUM_SHEET.get().getDefaultInstance()) // tab icon
                    .displayItems((parameters, output) -> {
                        // Materials
                        output.accept(MaterialItems.ALUMINUM_SHEET.get());
                        output.accept(MaterialItems.PLATINUM_SHEET.get());
                        output.accept(MaterialItems.SILVER_SHEET.get());
                        output.accept(MaterialItems.WOODEN_SHEET.get());

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
