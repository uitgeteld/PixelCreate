package xyz.uitgeteld.pixelcreate.item.pokeball;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.uitgeteld.pixelcreate.PixelCreate;

public class NormalPokeballs {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PixelCreate.MODID);

    public static final DeferredItem<Item> INCOMPLETE_POKE_BALL = ITEMS.register("incomplete_poke_ball",
            () -> new Item(new Item.Properties()) {
                @Override
                public boolean isEnabled(FeatureFlagSet enabledFeatures) {
                    return false;
                }
            });

    public static final DeferredItem<Item> INCOMPLETE_GREAT_BALL = ITEMS.register("incomplete_great_ball",
            () -> new Item(new Item.Properties()) {
                @Override
                public boolean isEnabled(FeatureFlagSet enabledFeatures) {
                    return false;
                }
            });

    public static final DeferredItem<Item> INCOMPLETE_ULTRA_BALL = ITEMS.register("incomplete_ultra_ball",
            () -> new Item(new Item.Properties()) {
                @Override
                public boolean isEnabled(FeatureFlagSet enabledFeatures) {
                    return false;
                }
            });
}
