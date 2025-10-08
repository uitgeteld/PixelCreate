package xyz.uitgeteld.pixelcreate;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import xyz.uitgeteld.pixelcreate.item.material.MaterialItems;
import xyz.uitgeteld.pixelcreate.item.pokeball.NormalPokeballs;
import xyz.uitgeteld.pixelcreate.item.pokeball.AncientPokeballs;
import xyz.uitgeteld.pixelcreate.tab.CreativeTab;

@Mod(PixelCreate.MODID)

public class PixelCreate {
    public static final String MODID = "pixelcreate";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PixelCreate(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);

        MaterialItems.ITEMS.register(modEventBus);
        NormalPokeballs.ITEMS.register(modEventBus);
        AncientPokeballs.ITEMS.register(modEventBus);
        CreativeTab.CREATIVE_MODE_TABS.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}
}
