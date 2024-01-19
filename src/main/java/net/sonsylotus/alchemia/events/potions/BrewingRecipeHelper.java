package net.sonsylotus.alchemia.events.potions;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.sonsylotus.alchemia.potion.AlchemiaPotions;

public class BrewingRecipeHelper {
    public static void addBrewingRecipe(Potion input, Item ingredient, Potion output) {
        BrewingRecipeRegistry.addRecipe(new AlchemiaPotions(input, ingredient, output));
    }
}
