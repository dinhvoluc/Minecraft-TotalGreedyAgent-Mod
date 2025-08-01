package tga;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import tga.Crops.CustomCropBlock;

import java.util.function.Function;

public final class TGAItems {
    public static Item RUBBER;
    public static Item REISIN;
    public static Item COPPER_PLATE;
    public static Item NAILS;
    public static Item CACO3;
    public static Item BOW_PRE_ACETONE;
    public static Item BOW_ACETONE;
    public static Item CROP_GUAYULE_GRASS;
    public static Item GUAYULE_DUST;
    public static Item TREE_WASTE;
    public static Item DUST_COPPER;
    public static Item DUST_TIN;
    public static Item DUST_BRONZE;
    public static Item INGOT_TIN;
    public static Item INGOT_BRONZE;

    public static void Load(boolean isClientSide) {
        SetBurnTime(RUBBER = register("rubber", Item::new, new Item.Settings()), 2000);
        SetBioBurnTime(REISIN = register("resin", Item::new, new Item.Settings()), 0.2f, 1000);
        COPPER_PLATE = register("plate_copper", Item::new, new Item.Settings());
        NAILS = register("nails", Item::new, new Item.Settings());
        CACO3 = register("c_caco3", Item::new, new Item.Settings());
        BOW_PRE_ACETONE = register("c_caco3_vinegar", Item::new, new Item.Settings());
        SetBurnTime(BOW_ACETONE = register("bow_acetone", Item::new, new Item.Settings()), 800);
        SetBioBurnTime(CROP_GUAYULE_GRASS = register("guayule_grass", Item::new, new Item.Settings()), 0.1f, 50);
        SetBioBurnTime(GUAYULE_DUST = register("guayule_dust", Item::new, new Item.Settings()), 0.8f, 400);
        SetBioBurnTime(TREE_WASTE = register("treewaste", Item::new, new Item.Settings()), 0.1f, 45);
        DUST_COPPER = register("d_copper", Item::new, new Item.Settings());
        DUST_TIN = register("d_tin", Item::new, new Item.Settings());
        DUST_BRONZE = register("d_bronze", Item::new, new Item.Settings());
        INGOT_TIN = register("ingot_tin", Item::new, new Item.Settings());
        INGOT_BRONZE = register("ingot_bronze", Item::new, new Item.Settings());
    }

    public static void SetBioValue(Item item, float rate) {
        CompostingChanceRegistry.INSTANCE.add(item, rate);
    }

    public static void SetBioBurnTime(Item item, float bioRate, int burnTicks) {
        CompostingChanceRegistry.INSTANCE.add(item, bioRate);
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(item, burnTicks);
        });
    }

    public static void SetBurnTime(Item item, int ticks) {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(item, ticks);
        });
    }

    private static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final Identifier identifier = TotalGreedyAgent.GetID(path);
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, identifier);
        return Items.register(registryKey, factory, settings);
    }
}