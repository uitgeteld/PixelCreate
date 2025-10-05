package xyz.uitgeteld.pixelcreate.item.pokeball;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.uitgeteld.pixelcreate.PixelCreate;

public class AncientPokeballs {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PixelCreate.MODID);

    public static final DeferredItem<Item> INCOMPLETE_ANCIENT_POKE_BALL = ITEMS.register("incomplete_ancient_poke_ball",
            () -> new Item(new Item.Properties()) {
                @Override
                public boolean isEnabled(FeatureFlagSet enabledFeatures) {
                    return false;
                }
            });

    public static final DeferredItem<Item> INCOMPLETE_ANCIENT_GREAT_BALL = ITEMS.register("incomplete_ancient_great_ball",
            () -> new Item(new Item.Properties()) {
                @Override
                public boolean isEnabled(FeatureFlagSet enabledFeatures) {
                    return false;
                }
            });

    public static final DeferredItem<Item> INCOMPLETE_ANCIENT_ULTRA_BALL = ITEMS.register("incomplete_ancient_ultra_ball",
            () -> new Item(new Item.Properties()) {
                @Override
                public boolean isEnabled(FeatureFlagSet enabledFeatures) {
                    return false;
                }
            });
}
