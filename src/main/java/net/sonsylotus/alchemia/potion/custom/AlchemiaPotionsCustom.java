package net.sonsylotus.alchemia.potion.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sonsylotus.alchemia.AlchemiaMod;
import net.sonsylotus.alchemia.effect.AlchemiaEffects;

public class AlchemiaPotionsCustom {

    public static final DeferredRegister<Potion> ALCHEMIA_POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, AlchemiaMod.MOD_ID);

    // Custom potions
    public static final RegistryObject<Potion> SLIMEY_POTION = ALCHEMIA_POTIONS.register("slimey_potion",
            () -> new Potion(new MobEffectInstance(AlchemiaEffects.SLIMEY_EFFECT.get(), 200, 0)));

    public static final RegistryObject<Potion> RANDOM_POTION = ALCHEMIA_POTIONS.register("random_potion",
            () -> new Potion(new MobEffectInstance(AlchemiaEffects.RANDOM_TELEPORT.get(), 20, 0)));

    public static final RegistryObject<Potion> HARMFUL_AURA_POTION = ALCHEMIA_POTIONS.register("harmful_aura_potion",
            () -> new Potion(new MobEffectInstance(AlchemiaEffects.HARMFUL_AURA.get(), 200, 0)));

    public static final RegistryObject<Potion> CONFUSION_POTION = ALCHEMIA_POTIONS.register("confusion_potion",
            () -> new Potion(new MobEffectInstance(AlchemiaEffects.CONFUSION.get(), 200, 0)));

    public static void register(IEventBus eventBus) {

        ALCHEMIA_POTIONS.register(eventBus);

    }
}
