package xyz.uitgeteld.pixelcreate.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.uitgeteld.pixelcreate.PixelCreate;
import xyz.uitgeteld.pixelcreate.fluid.ModFluids;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PixelCreate.MODID);

    public static final DeferredItem<Item> ALUMINUM_SHEET = ITEMS.registerSimpleItem("aluminum_sheet", new Item.Properties());
    public static final DeferredItem<Item> PLATINUM_SHEET = ITEMS.registerSimpleItem("platinum_sheet", new Item.Properties());
    public static final DeferredItem<Item> SILVER_SHEET = ITEMS.registerSimpleItem("silver_sheet", new Item.Properties());
    public static final DeferredItem<Item> WOODEN_SHEET = ITEMS.registerSimpleItem("wooden_sheet", new Item.Properties());

    public static final DeferredItem<Item> DEEPSLATE_CHUNK = ITEMS.registerSimpleItem("deepslate_chunk", new Item.Properties());
    public static final DeferredItem<Item> RAW_IRON_CHUNK = ITEMS.registerSimpleItem("raw_iron_chunk", new Item.Properties());
    public static final DeferredItem<Item> RAW_COPPER_CHUNK = ITEMS.registerSimpleItem("raw_copper_chunk", new Item.Properties());
    public static final DeferredItem<Item> RAW_ZINC_CHUNK = ITEMS.registerSimpleItem("raw_zinc_chunk", new Item.Properties());
    public static final DeferredItem<Item> RAW_BAUXITE_CHUNK = ITEMS.registerSimpleItem("raw_bauxite_chunk", new Item.Properties());
    public static final DeferredItem<Item> RAW_GOLD_CHUNK = ITEMS.registerSimpleItem("raw_gold_chunk", new Item.Properties());
    public static final DeferredItem<Item> RAW_SILVER_CHUNK = ITEMS.registerSimpleItem("raw_silver_chunk", new Item.Properties());
    public static final DeferredItem<Item> RAW_PLATINUM_CHUNK = ITEMS.registerSimpleItem("raw_platinum_chunk", new Item.Properties());

    public static final DeferredHolder<Item, BucketItem> MOLTEN_IRON_BUCKET =
            ITEMS.register("molten_iron_bucket",
                    () -> new BucketItem(ModFluids.MOLTEN_IRON.get(),
                            new Item.Properties()
                                    .craftRemainder(Items.BUCKET)
                                    .stacksTo(1)));
}
