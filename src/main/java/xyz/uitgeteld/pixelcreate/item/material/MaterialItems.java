package xyz.uitgeteld.pixelcreate.item.material;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.uitgeteld.pixelcreate.PixelCreate;

public class MaterialItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PixelCreate.MODID);

    public static final DeferredItem<Item> ALUMINUM_SHEET = ITEMS.registerSimpleItem("aluminum_sheet", new Item.Properties());
    public static final DeferredItem<Item> PLATINUM_SHEET = ITEMS.registerSimpleItem("platinum_sheet", new Item.Properties());
    public static final DeferredItem<Item> SILVER_SHEET = ITEMS.registerSimpleItem("silver_sheet", new Item.Properties());
    public static final DeferredItem<Item> WOODEN_SHEET = ITEMS.registerSimpleItem("wooden_sheet", new Item.Properties());
}
