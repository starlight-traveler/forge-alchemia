package net.sonsylotus.alchemia.potion.vanilla;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sonsylotus.alchemia.AlchemiaMod;

public class AlchemiaPotionsVanilla {
    public static final DeferredRegister<Potion> ALCHEMIA_POTIONS_VANILLA =
            DeferredRegister.create(ForgeRegistries.POTIONS, AlchemiaMod.MOD_ID);

    public static RegistryObject<Potion> registerPotion(String name, MobEffect effect, int duration, int amplifier) {
        return ALCHEMIA_POTIONS_VANILLA.register(name, () -> new Potion(new MobEffectInstance(effect, duration, amplifier)));
    }


    // Blindness

    public static final RegistryObject<Potion> BLINDNESS = registerPotion("blindness", MobEffects.BLINDNESS, 900, 0);
    public static final RegistryObject<Potion> EXTENDED_BLINDNESS = registerPotion("extended_blindness", MobEffects.BLINDNESS, 1800, 0);

    // Nausea

    public static final RegistryObject<Potion> NAUSEA = registerPotion("nausea", MobEffects.CONFUSION, 900, 0);
    public static final RegistryObject<Potion> EXTENDED_NAUSEA = registerPotion("extended_nausea", MobEffects.CONFUSION, 1800, 0);
    public static final RegistryObject<Potion> POTENT_NAUSEA = registerPotion("potent_nausea", MobEffects.CONFUSION, 900, 1);

    // Health Boost

    public static final RegistryObject<Potion> HEALTH_BOOST = registerPotion("health_boost", MobEffects.HEALTH_BOOST, 900, 0);
    public static final RegistryObject<Potion> EXTENDED_HEALTH_BOOST = registerPotion("extended_health_boost", MobEffects.HEALTH_BOOST, 1800, 0);
    public static final RegistryObject<Potion> POTENT_HEALTH_BOOST = registerPotion("potent_health_boost", MobEffects.HEALTH_BOOST, 450, 1);

    // Absorption

    public static final RegistryObject<Potion> ABSORPTION = registerPotion("absorption", MobEffects.ABSORPTION, 3600, 0);
    public static final RegistryObject<Potion> EXTENDED_ABSORPTION = registerPotion("extended_absorption", MobEffects.ABSORPTION, 9600, 0);
    public static final RegistryObject<Potion> POTENT_ABSORPTION = registerPotion("potent_absorption", MobEffects.ABSORPTION, 1800, 1);

    // Glowing

    public static final RegistryObject<Potion> GLOWING = registerPotion("glowing", MobEffects.GLOWING, 1800, 0);
    public static final RegistryObject<Potion> EXTENDED_GLOWING = registerPotion("extended_glowing", MobEffects.GLOWING, 4800, 0);

    // Resistance

    public static final RegistryObject<Potion> RESISTANCE = registerPotion("resistance", MobEffects.DAMAGE_RESISTANCE, 3600, 0);
    public static final RegistryObject<Potion> EXTENDED_RESISTANCE = registerPotion("extended_resistance", MobEffects.DAMAGE_RESISTANCE, 9600, 0);
    public static final RegistryObject<Potion> POTENT_RESISTANCE = registerPotion("potent_resistance", MobEffects.DAMAGE_RESISTANCE, 1800, 1);

    // Wither

    public static final RegistryObject<Potion> WITHER = registerPotion("wither", MobEffects.WITHER, 900, 0);
    public static final RegistryObject<Potion> EXTENDED_WITHER = registerPotion("extended_wither", MobEffects.WITHER, 1800, 0);
    public static final RegistryObject<Potion> POTENT_WITHER = registerPotion("potent_wither", MobEffects.WITHER, 450, 1);

    // Dolphin's Grace
    public static final RegistryObject<Potion> DOLPHINS_GRACE = registerPotion("dolphins_grace", MobEffects.WITHER, 450, 0);
    public static final RegistryObject<Potion> EXTENDED_DOLPHINS_GRACE = registerPotion("extended_dolphins_grace", MobEffects.DOLPHINS_GRACE, 900, 0);

    // Darkness

    public static final RegistryObject<Potion> DARKNESS = registerPotion("darkness", MobEffects.DARKNESS, 450, 0);
    public static final RegistryObject<Potion> EXTENDED_DARKNESS = registerPotion("extended_darkness", MobEffects.DARKNESS, 900, 0);

    // Unlucky

    public static final RegistryObject<Potion> UNLUCKY = registerPotion("unlucky", MobEffects.UNLUCK, 450, 0);
    public static final RegistryObject<Potion> EXTENDED_UNLUCKINESS = registerPotion("extended_unluckiness", MobEffects.UNLUCK, 900, 0);
    public static final RegistryObject<Potion> POTENT_UNLUCKINESS = registerPotion("potent_unluckiness", MobEffects.UNLUCK, 450, 1);


    // Bad Omen

    public static final RegistryObject<Potion> BAD_OMEN = registerPotion("bad_omen", MobEffects.BAD_OMEN, 450, 0);
    public static final RegistryObject<Potion> POTENT_BAD_OMEN_I = registerPotion("bad_omen_one", MobEffects.BAD_OMEN, 450, 1);
    public static final RegistryObject<Potion> POTENT_BAD_OMEN_II = registerPotion("bad_omen_two", MobEffects.BAD_OMEN, 450, 2);
    public static final RegistryObject<Potion> POTENT_BAD_OMEN_III = registerPotion("bad_omen_three", MobEffects.BAD_OMEN, 450, 3);
    public static final RegistryObject<Potion> POTENT_BAD_OMEN_IV = registerPotion("bad_omen_four", MobEffects.BAD_OMEN, 450, 4);
    public static final RegistryObject<Potion> POTENT_BAD_OMEN_V = registerPotion("bad_omen_five", MobEffects.BAD_OMEN, 450, 5);


    // Levitation

    public static final RegistryObject<Potion> LEVITATION = registerPotion("levitation", MobEffects.LEVITATION, 450, 0);
    public static final RegistryObject<Potion> EXTENDED_LEVITATION = registerPotion("extended_leviation", MobEffects.LEVITATION, 900, 0);

    // Conduit Power

    public static final RegistryObject<Potion> CONDUIT_POWER = registerPotion("conduit", MobEffects.CONDUIT_POWER, 450, 0);
    public static final RegistryObject<Potion> EXTENDED_CONDUIT_POWER = registerPotion("conduit_power", MobEffects.CONDUIT_POWER, 900, 0);


    public static void register(IEventBus eventBus) {

        ALCHEMIA_POTIONS_VANILLA.register(eventBus);

    }
}
