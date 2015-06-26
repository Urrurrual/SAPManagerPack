/**
 * ****************************************************************************************************************
 * Authors:   SanAndreasP
 * Copyright: SanAndreasP
 * License:   Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 * *****************************************************************************************************************
 */
package de.sanandrew.core.manpack.util.helpers;

import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.registry.GameRegistry;
import de.sanandrew.core.manpack.util.SAPReflectionHelper;
import de.sanandrew.core.manpack.util.javatuples.Quartet;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.*;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * A helper class for common used stuff, which is not found somewhere else and
 * not as easy and short to write. It's goal is to shorten and cleanse the
 * sourcecode with unnecessary stuff.
 */
public final class SAPUtils
{
    /** My personal RNG Deity, to be used whenever a global RNG is needed */
    public static final Random RNG = new Random();

    public static final EventBus EVENT_BUS = new EventBus();

    @Deprecated
    public static ItemStack decrStackSize(ItemStack stack) {
        return ItemUtils.decrStackSize(stack, 1);
    }

    @Deprecated
    public static ItemStack decrStackSize(ItemStack stack, int amount) {
        return ItemUtils.decrStackSize(stack, amount);
    }

    @Deprecated
    public static ItemStack decrInvStackSize(ItemStack stack, int amount) {
        return ItemHelper.decrInvStackSize(stack, amount);
    }

    @Deprecated
    public static boolean areStacksEqualWithWCV(ItemStack stack1, ItemStack stack2) {
        return ItemUtils.areStacksEqual(stack1, stack2, false);
    }

    @Deprecated
    public static boolean areStacksEqual(ItemStack stack1, ItemStack stack2, boolean checkNbt) {
        return ItemUtils.areStacksEqual(stack1, stack2, checkNbt);
    }

    @Deprecated
    public static ItemStack[] getGoodItemStacks(ItemStack stack) {
        return ItemUtils.getGoodItemStacks(stack);
    }

    /**
     * Gets a value in the middle of 2 values, for example val1 is 1 and val2 is 5, the value returned would be 3.
     * Note: val1 doesn't have to be smaller than val2
     * @param val1 the first value
     * @param val2 the second value
     * @return the value in between val1 and val2
     */
    public static int getInBetweenVal(int val1, int val2) {
        int maxVal = Math.max(val1, val2);
        int minVal = Math.min(val1, val2);
        return Math.round((maxVal + minVal) / 2.0F);
    }

    /**
     * public reflection getter for {@link net.minecraft.block.Block#createStackedBlock(int)}.
     * @param block The block which will invoke the method
     * @param meta the metadata of the invoking block
     * @return the return value from the invoked method
     */
    public static ItemStack getSilkBlock(Block block, int meta) {
        return SAPReflectionHelper.invokeCachedMethod(Block.class, block, "createStackedBlock", "func_71880_c_", new Class[]{int.class}, new Object[]{meta});
    }

    @Deprecated
    public static void dropBlockAsItem(Block block, World world, int x, int y, int z, ItemStack stack) {
        dropBlockAsItem(world, x, y, z, stack);
    }

    @Deprecated
    public static void dropBlockAsItem(World world, int x, int y, int z, ItemStack stack) {
        EntityItem item = new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, stack);
        world.spawnEntityInWorld(item);
    }

    @Deprecated
    public static void dropBlockXP(Block block, World world, int x, int y, int z, int meta, int fortune) {
        block.dropXpOnBlockBreak(world, x, y, z, block.getExpDrop(world, meta, fortune));
    }

    @Deprecated
    public static boolean isItemInStackArray(ItemStack base, ItemStack... stackArray) {
        return ItemUtils.isItemStackInArray(base, false, stackArray);
    }

    @Deprecated
    public static boolean isItemInStackArray(ItemStack base, List<ItemStack> stackArray) {
        return ItemUtils.isItemStackInArray(base, false, stackArray.toArray(new ItemStack[stackArray.size()]));
    }

    @Deprecated
    public static boolean isItemInStackArray(ItemStack base, boolean checkSize, ItemStack... stackArray) {
        return ItemUtils.isItemStackInArray(base, checkSize, stackArray);
    }

    @Deprecated
    public static boolean isItemInStackArray(ItemStack base, boolean checkSize, List<ItemStack> stackArray) {
        return ItemUtils.isItemStackInArray(base, checkSize, stackArray.toArray(new ItemStack[stackArray.size()]));
    }

    /**
     * Gets the effective blocks array from the ItemTool.
     * @param tool The ItemTool instance whose array should be grabbed
     * @return the effective blocks array
     */
    @SuppressWarnings("unchecked")
    public static Block[] getToolBlocks(ItemTool tool) {
        Set set = SAPReflectionHelper.getCachedFieldValue(ItemTool.class, tool, "field_150914_c", "field_150914_c");
        Set<Block> blockSet = (Set<Block>) set;
        return blockSet.toArray(new Block[blockSet.size()]);
    }

    @Deprecated
    public static boolean isToolEffective(Block[] effectives, Block block) {
        for( Block currBlock : effectives ) {
            if( block == currBlock ) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static boolean areItemInstEqual(Object instance1, Object instance2) {
        return ItemHelper.areItemInstEqual(instance1, instance2);
    }

    @Deprecated
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> T[] getArrayFromCollection(Collection<T> collection, Class clazz) {
        if( collection.size() == 0 ) {
            return null;
        }
        T[] myArray = (T[]) Array.newInstance(clazz, collection.size());
        collection.toArray(myArray);
        return myArray;
    }

    /**
     * Registers all blocks with their unlocalized name to the GameRegistry.
     * @param blocks The blocks to be registered
     * @see GameRegistry#registerBlock(Block, String)
     */
    public static void registerBlocks(Block... blocks) {
        for( Block block : blocks ) {
            String blockName = block.getUnlocalizedName();
            blockName = blockName.substring(blockName.lastIndexOf(':')+1);
            GameRegistry.registerBlock(block, blockName.toLowerCase());
        }
    }

    /**
     * Registers a block with their unlocalized name to the GameRegistry. It binds the supplied itemClass as its ItemBlock to this block.
     * @param block The block to be registered
     * @param itemClass the ItemBlock class to be bound to the block
     * @see GameRegistry#registerBlock(Block, Class, String)
     */
    public static void registerBlockWithItem(Block block, Class<? extends ItemBlock> itemClass) {
        String blockName = block.getUnlocalizedName();
        blockName = blockName.substring(blockName.lastIndexOf(':') + 1);
        GameRegistry.registerBlock(block, itemClass, blockName.toLowerCase());
    }

    /**
     * Registers all items with their unlocalized name to the GameRegistry.
     * @param items The blocks to be registered
     * @see GameRegistry#registerItem(Item, String)
     */
    public static void registerItems(Item... items) {
        for( Item item : items ) {
            String itemName = item.getUnlocalizedName();
            itemName = itemName.substring(itemName.lastIndexOf(':')+1);
            GameRegistry.registerItem(item, itemName.toLowerCase());
        }
    }

    @Deprecated
    public static ItemStack addItemStackToInventory(ItemStack is, IInventory inv) {
        return InventoryUtils.addStackToInventory(is, inv);
    }

    /**
     * Gets an {@link de.sanandrew.core.manpack.util.helpers.SAPUtils.RGBAValues} instance from a color integer (0xAARRGGBB).
     * @param rgba The RGBA value as int
     * @return an RGBAValues instance
     */
    public static RGBAValues getRgbaFromColorInt(int rgba) {
        return new RGBAValues(((rgba) >> 16) & 255, ((rgba) >> 8) & 255, rgba & 255, ((rgba) >> 24) & 255);
    }

    @Deprecated
    public static File getMcDir(String path) {
        return new File(".", path);
    }

    public static void restartApp() {
        AppHelper.restartApp();
    }

    public static void shutdownApp() {
        AppHelper.shutdownApp();
    }

    /**
     * Checks if the index is within the range of the array.
     * @param array The array to check against
     * @param index The index to be checked
     * @return true, if the index is within range, false otherwise
     */
    public static boolean isIndexInRange(Object[] array, int index) {
        return index >= 0 && index < array.length;
    }

    @Deprecated
    public static DamageSource getNewDamageSource(String type) {
        try {
            Constructor<DamageSource> dmgsrcConst = DamageSource.class.getDeclaredConstructor(String.class);
            dmgsrcConst.setAccessible(true);
            return dmgsrcConst.newInstance(type);
        } catch( Throwable e ) {
            e.printStackTrace();
        }
        return null;
    }

    @Deprecated
    public static int getMaxDmgFactorAM(ItemArmor.ArmorMaterial aMaterial) {
        return SAPReflectionHelper.getCachedFieldValue(ItemArmor.ArmorMaterial.class, aMaterial, "maxDamageFactor", "field_78048_f");
    }

    /**
     * Registers a new IRecipe instance into the RecipeSorter and the CraftingManager
     * @param recipe The recipe to be registered
     * @param name the recipe name
     * @param category the recipe category it will be sorted in
     * @param dependencies a string representing the dependencies for this recipe
     */
    @SuppressWarnings("unchecked")
    public static void registerSortedRecipe(IRecipe recipe, String name, Category category, String dependencies) {
        RecipeSorter.register(name, recipe.getClass(), category, dependencies);
        CraftingManager.getInstance().getRecipeList().add(recipe);
    }

    /**
     * translates a key via {@link StatCollector#translateToLocal(String)}
     * @param key The key to be translated
     * @return The translated key
     */
    public static String translate(String key) {
        return StatCollector.translateToLocal(key);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getCasted(Object obj) {
        return (T)obj;
    }

    /**
     * translates a key and then formats the translated string with the data afterwards.
     * @param key The key to be translated
     * @param data The data to be injected into the translated string
     * @return The translated string
     */
    public static String translatePostFormat(String key, Object... data) {
        return String.format(translate(key), data);
    }

    /**
     * formats a key with the data and translates the formated string afterwards.
     * @param key The key to be translated
     * @param data The data to be injected into the key
     * @return The translated string
     */
    public static String translatePreFormat(String key, Object... data) {
        return translate(String.format(key, data));
    }

    public static class RGBAValues {
        private final Quartet<Integer, Integer, Integer, Integer> value;

        public RGBAValues(int r, int g, int b, int a) {
            this.value = Quartet.with(r, g, b, a);
        }

        public int getRed() {
            return this.value.getValue0();
        }

        public int getGreen() {
            return this.value.getValue1();
        }

        public int getBlue() {
            return this.value.getValue2();
        }

        public int getAlpha() {
            return this.value.getValue3();
        }

        public float[] getColorFloatArray() {
            return new float[] {this.getRed() / 255.0F, this.getGreen() / 255.0F, this.getBlue() / 255.0F, this.getAlpha() / 255.0F};
        }
    }
}
