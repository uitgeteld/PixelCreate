package xyz.uitgeteld.pixelcreate;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import xyz.uitgeteld.pixelcreate.item.material.MaterialItems;
import xyz.uitgeteld.pixelcreate.item.pokeball.NormalPokeballs;
import xyz.uitgeteld.pixelcreate.item.pokeball.AncientPokeballs;

@Mod(PixelCreate.MODID)
public class PixelCreate {
    public static final String MODID = "pixelcreate";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

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

    public PixelCreate(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);

        MaterialItems.ITEMS.register(modEventBus);
        NormalPokeballs.ITEMS.register(modEventBus);
        AncientPokeballs.ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}
}
