package net.sonsylotus.alchemia.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.sonsylotus.alchemia.AlchemiaMod;
import net.sonsylotus.alchemia.effect.AlchemiaEffects;
import net.sonsylotus.alchemia.events.potions.BrewingRecipeHelper;
import net.sonsylotus.alchemia.potion.custom.AlchemiaPotionsCustom;
import net.sonsylotus.alchemia.potion.vanilla.AlchemiaPotionsVanilla;
@Mod.EventBusSubscriber(modid = AlchemiaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class AlchemiaEvents {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void confusionEffectUpdate(MovementInputUpdateEvent event) {
        assert Minecraft.getInstance().player != null;
        if (!Minecraft.getInstance().player.hasEffect(AlchemiaEffects.CONFUSION.get())) {
            return;
        }

        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }

        Input input = event.getInput();
        input.up = false;
        input.down = false;
        input.left = false;
        input.right = false;
        input.forwardImpulse = -1 * input.forwardImpulse;
        input.leftImpulse = -1 * input.leftImpulse;

        // Switch jumping and shift keys
        boolean wasJumping = input.jumping;
        input.jumping = input.shiftKeyDown;
        input.shiftKeyDown = wasJumping;
    }

//    @SubscribeEvent
//    @OnlyIn(Dist.CLIENT)
//    public void inputUpdate(MovementInputUpdateEvent event) {
//        Input input = event.getInput();
//
//        // Inverting the impulse values for forward and backward movement
//        input.forwardImpulse = -1;
//
//        // Inverting the impulse values for left and right movement
//        input.leftImpulse = -input.leftImpulse;
//
//        // Invert the up/down, left/right boolean values
//        boolean wasMovingUp = input.up;
//        boolean wasMovingDown = input.down;
//        boolean wasMovingLeft = input.left;
//        boolean wasMovingRight = input.right;
//
//        input.up = wasMovingDown;
//        input.down = wasMovingUp;
//        input.left = wasMovingRight;
//        input.right = wasMovingLeft;
//
//        // Inverting jumping and sneaking states
//        boolean wasJumping = input.jumping;
//        boolean wasSneaking = input.shiftKeyDown;
//
//        input.jumping = wasSneaking;
//        input.shiftKeyDown = wasJumping;
//    }



    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            // Slimey Potion Effect
            BrewingRecipeHelper.addBrewingRecipe(Potions.AWKWARD, Items.SLIME_BALL, AlchemiaPotionsCustom.SLIMEY_POTION.get());

            // Blindness Potion Effect
            BrewingRecipeHelper.addBrewingRecipe(Potions.AWKWARD, Items.INK_SAC, AlchemiaPotionsVanilla.BLINDNESS.get());
            BrewingRecipeHelper.addBrewingRecipe(AlchemiaPotionsVanilla.BLINDNESS.get(), Items.REDSTONE, AlchemiaPotionsVanilla.EXTENDED_BLINDNESS.get());

            // Nausea Potion Effect
            BrewingRecipeHelper.addBrewingRecipe(Potions.AWKWARD, Items.POISONOUS_POTATO, AlchemiaPotionsVanilla.NAUSEA.get());
            BrewingRecipeHelper.addBrewingRecipe(AlchemiaPotionsVanilla.NAUSEA.get(), Items.REDSTONE, AlchemiaPotionsVanilla.EXTENDED_NAUSEA.get());

            // Absorption Potion Effect
            BrewingRecipeHelper.addBrewingRecipe(Potions.AWKWARD, Items.GOLDEN_CARROT, AlchemiaPotionsVanilla.ABSORPTION.get());
            BrewingRecipeHelper.addBrewingRecipe(AlchemiaPotionsVanilla.ABSORPTION.get(), Items.REDSTONE, AlchemiaPotionsVanilla.EXTENDED_ABSORPTION.get());
            BrewingRecipeHelper.addBrewingRecipe(AlchemiaPotionsVanilla.ABSORPTION.get(), Items.GLOWSTONE_DUST, AlchemiaPotionsVanilla.POTENT_ABSORPTION.get());

            // Health Boost Potion Effect
            BrewingRecipeHelper.addBrewingRecipe(Potions.AWKWARD, Items.GOLDEN_APPLE, AlchemiaPotionsVanilla.HEALTH_BOOST.get());
            BrewingRecipeHelper.addBrewingRecipe(AlchemiaPotionsVanilla.HEALTH_BOOST.get(), Items.REDSTONE, AlchemiaPotionsVanilla.EXTENDED_HEALTH_BOOST.get());
            BrewingRecipeHelper.addBrewingRecipe(AlchemiaPotionsVanilla.HEALTH_BOOST.get(), Items.REDSTONE, AlchemiaPotionsVanilla.POTENT_HEALTH_BOOST.get());

            // Glowing Potion Effect
            BrewingRecipeHelper.addBrewingRecipe(Potions.AWKWARD, Items.SPECTRAL_ARROW, AlchemiaPotionsVanilla.GLOWING.get());
            BrewingRecipeHelper.addBrewingRecipe(AlchemiaPotionsVanilla.GLOWING.get(), Items.REDSTONE, AlchemiaPotionsVanilla.EXTENDED_GLOWING.get());

            // Resistance Potion Effect
            BrewingRecipeHelper.addBrewingRecipe(Potions.AWKWARD, Items.SHULKER_SHELL, AlchemiaPotionsVanilla.RESISTANCE.get());
            BrewingRecipeHelper.addBrewingRecipe(AlchemiaPotionsVanilla.RESISTANCE.get(), Items.REDSTONE, AlchemiaPotionsVanilla.EXTENDED_RESISTANCE.get());
            BrewingRecipeHelper.addBrewingRecipe(AlchemiaPotionsVanilla.RESISTANCE.get(), Items.GLOWSTONE, AlchemiaPotionsVanilla.POTENT_RESISTANCE.get());

            // Wither Potion Effect
            BrewingRecipeHelper.addBrewingRecipe(Potions.MUNDANE, Items.WITHER_ROSE, AlchemiaPotionsVanilla.WITHER.get());
            BrewingRecipeHelper.addBrewingRecipe(AlchemiaPotionsVanilla.WITHER.get(), Items.REDSTONE, AlchemiaPotionsVanilla.EXTENDED_WITHER.get());
            BrewingRecipeHelper.addBrewingRecipe(AlchemiaPotionsVanilla.WITHER.get(), Items.GLOWSTONE, AlchemiaPotionsVanilla.POTENT_WITHER.get());

        });
    }

}
