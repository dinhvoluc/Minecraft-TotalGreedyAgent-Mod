package tga;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import tga.MachineRecipes.OneInRecipe;
import tga.MachineRecipes.OneMainAndLuck;
import tga.MachineRecipes.OneSlotBook;
import tga.MachineRecipes.OneToOne;

public class TGARecipes {
    public static OneSlotBook Cracker_LV0 = new OneSlotBook();
    public static OneSlotBook Cracker_LV1 = new OneSlotBook();
    public static OneSlotBook Cracker_LV2 = new OneSlotBook();
    public static void Load(){
        //CaCO3
        AddCrackerRecipes(0, OneToOne.CreateWithTagsIngredient(5_000_00, new ItemStack(TGAItems.CACO3), new ItemStack(Items.NAUTILUS_SHELL, 2), new ItemStack(Items.TURTLE_SCUTE), new ItemStack(Items.BONE_BLOCK), new ItemStack(Items.BONE, 3)));

        //Guayule seed/dust
        AddCrackerRecipes(0, new OneMainAndLuck(new ItemStack(TGAItems.CROP_GUAYULE_GRASS), 500_00, new ItemStack(TGAItems.GUAYULE_DUST), new ItemStack(TGABlocks.CROP_GUAYULE_YONG), 0.15f));
        AddCrackerRecipes(0, new OneMainAndLuck(new ItemStack(Items.SHORT_GRASS), 200_00, new ItemStack(TGAItems.TREE_WASTE), new ItemStack(TGABlocks.CROP_GUAYULE_YONG), 0.05f));
        AddCrackerRecipes(1, new OneToOne(new ItemStack(TGABlocks.CROP_GUAYULE_YONG, 5), 800_00, new ItemStack(TGAItems.GUAYULE_DUST)));

        //ORE crush
        AddCrackerRecipes(0, new OneMainAndLuck(new ItemStack(Items.RAW_COPPER_BLOCK), 20_000_00, new ItemStack(TGAItems.DUST_COPPER, 10), new ItemStack(TGAItems.DUST_TIN), 10f));

        //INGOT CRUSH
        AddCrackerRecipes(0, OneToOne.CreateAutoBlanced(TGAItems.DUST_TIN, 90, 1_500_00, 12_00,
                90, TGAItems.INGOT_TIN));

        AddCrackerRecipes(0, OneToOne.CreateAutoBlanced(TGAItems.DUST_COPPER, 90, 2_000_00, 30_00,
                90, Items.COPPER_INGOT, TGAItems.COPPER_PLATE,
                810,
                Items.COPPER_BLOCK,
                Items.CHISELED_COPPER, Items.COPPER_GRATE, Items.CUT_COPPER,
                Items.EXPOSED_CHISELED_COPPER, Items.EXPOSED_COPPER_GRATE, Items.EXPOSED_CUT_COPPER,
                Items.OXIDIZED_CHISELED_COPPER, Items.OXIDIZED_COPPER_GRATE, Items.OXIDIZED_CUT_COPPER,

                Items.WAXED_COPPER_BLOCK,
                Items.WAXED_CHISELED_COPPER, Items.WAXED_COPPER_GRATE, Items.WAXED_CUT_COPPER,
                Items.WAXED_EXPOSED_CHISELED_COPPER, Items.WAXED_EXPOSED_COPPER_GRATE, Items.WAXED_EXPOSED_CUT_COPPER,
                Items.WAXED_OXIDIZED_CHISELED_COPPER, Items.WAXED_OXIDIZED_COPPER_GRATE, Items.WAXED_OXIDIZED_CUT_COPPER,

                540,
                Items.CUT_COPPER_STAIRS, Items.EXPOSED_CUT_COPPER_STAIRS, Items.OXIDIZED_CUT_COPPER_STAIRS,

                Items.WAXED_CUT_COPPER_STAIRS, Items.WAXED_EXPOSED_CUT_COPPER_STAIRS, Items.WAXED_OXIDIZED_CUT_COPPER_STAIRS,

                405,
                Items.CUT_COPPER_SLAB, Items.EXPOSED_CUT_COPPER_SLAB, Items.OXIDIZED_CUT_COPPER_SLAB,
                Items.WAXED_CUT_COPPER_SLAB, Items.WAXED_EXPOSED_CUT_COPPER_SLAB, Items.WAXED_OXIDIZED_CUT_COPPER_SLAB,

                270,
                Items.COPPER_TRAPDOOR, Items.EXPOSED_COPPER_TRAPDOOR, Items.OXIDIZED_COPPER_TRAPDOOR,
                Items.WAXED_COPPER_TRAPDOOR, Items.WAXED_EXPOSED_COPPER_TRAPDOOR, Items.WAXED_OXIDIZED_COPPER_TRAPDOOR,

                180,
                Items.COPPER_DOOR, Items.EXPOSED_COPPER_DOOR, Items.OXIDIZED_COPPER_DOOR,
                Items.WAXED_COPPER_DOOR, Items.WAXED_EXPOSED_COPPER_DOOR, Items.WAXED_OXIDIZED_COPPER_DOOR));

        AddCrackerRecipes(0, OneToOne.CreateAutoBlanced(TGAItems.DUST_BRONZE, 90, 2_300_00, 40_00,
                90, TGAItems.INGOT_BRONZE));
    }
    public static void AddCrackerRecipes(int minlv, OneInRecipe... recipe) {
        if (minlv <= 0) Cracker_LV0.Registers(recipe);
        if (minlv <= 1) Cracker_LV1.Registers(recipe);
        if (minlv <= 2) Cracker_LV2.Registers(recipe);
    }
}