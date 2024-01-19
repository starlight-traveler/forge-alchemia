package net.sonsylotus.alchemia.potion;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;

/**
 * Custom brewing recipe class for enhanced potion brewing functionality.
 */
public class AlchemiaPotions implements IBrewingRecipe {
    private final Potion input;
    private final Item ingredient;
    private final Potion output;

    /**
     * Constructs a new potion recipe with specified input, ingredient, and output.
     *
     * @param input      The input potion for the recipe.
     * @param ingredient The ingredient item for the recipe.
     * @param output     The output potion for the recipe.
     */
    public AlchemiaPotions(Potion input, Item ingredient, Potion output) {
        this.input = input;
        this.ingredient = ingredient;
        this.output = output;
    }

    @Override
    public boolean isInput(ItemStack input) {
        return PotionUtils.getPotion(input) == this.input;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return ingredient.getItem() == this.ingredient;
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if (!this.isInput(input) || !this.isIngredient(ingredient)) {
            return ItemStack.EMPTY;
        }

        // Reuse the input tag if it exists to avoid unnecessary object creation
        CompoundTag tag = input.hasTag() ? input.getTag().copy() : new CompoundTag();
        ItemStack outputStack = new ItemStack(input.getItem());
        outputStack.setTag(tag);
        PotionUtils.setPotion(outputStack, this.output);
        return outputStack;
    }
}
