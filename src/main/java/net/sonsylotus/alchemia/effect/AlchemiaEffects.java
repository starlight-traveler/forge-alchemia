package net.sonsylotus.alchemia.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sonsylotus.alchemia.AlchemiaMod;
import net.sonsylotus.alchemia.effect.custom.*;

/**
 * ModEffects class handles the registration and management of custom mob effects in the MCCourseMod.
 */
public class AlchemiaEffects {
    // DeferredRegister is used to create registries for mod objects.
    // Here, it is used to register custom mob effects.
    // MOB_EFFECTS is a static final field representing the registry of mob effects for the mod.
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AlchemiaMod.MOD_ID);

    // RegistryObject is a wrapper around a registry entry, which delays its creation and registration until necessary.
    // SLIMEY_EFFECT is a static final field holding the registry object of the custom mob effect.
    // The actual effect is created using a lambda expression, providing the effect instance only when needed.
    public static final RegistryObject<MobEffect> SLIMEY_EFFECT = MOB_EFFECTS.register("slimey",
            () -> new SlimeyEffect(MobEffectCategory.NEUTRAL, 0x36ebab)
                    // The addAttributeModifier method is used to add an attribute modifier to the effect.
                    // Here, it modifies the MOVEMENT_SPEED attribute, decreasing it by 25%.
                    // The UUID provided must be unique to avoid conflicts with other modifiers.
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            "7107AE5E-7CE8-4030-940E-514C1F160890", -0.25f, AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final RegistryObject<MobEffect> ARMOR = MOB_EFFECTS.register("armor",
            () -> new ArmorEffect(MobEffectCategory.BENEFICIAL, 0x888888)
                    .addAttributeModifier(Attributes.ARMOR,
                        "68685544-A337-4959-B1AD-ACCE62A583BE", 4f, AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<MobEffect> KNOCKBACK_RESISTANCE = MOB_EFFECTS.register("knockback_resistance",
            () -> new KnockBackResistanceEffect(MobEffectCategory.BENEFICIAL, 0x5C02DE)
                    .addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE,
                            "0DDC9275-7E9A-4662-8D3F-D8DF344444E0", 0.15D, AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<MobEffect> RANDOM_TELEPORT = MOB_EFFECTS.register("random_teleport",
            () -> new RandomTeleportationEffect(MobEffectCategory.BENEFICIAL, 0x2D2D3D)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            "74738ff5-5367-5958-9aee-98fffdcd1876", 0.15D, AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<MobEffect> HARMFUL_AURA = MOB_EFFECTS.register("harmful_aura",
            () -> new HarmfulAuraEffect(MobEffectCategory.HARMFUL, 0x3D243D)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            "74738ff5-5367-5958-9bee-98fffdcd1876", -0.25f, AttributeModifier.Operation.MULTIPLY_TOTAL));

    public static final RegistryObject<MobEffect> CONFUSION = MOB_EFFECTS.register("confusion",
            () -> new ConfusionEffect(MobEffectCategory.HARMFUL, 0xA1243D)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            "74748ff5-5367-5958-9bee-98fffdcd1876", -0.25f, AttributeModifier.Operation.MULTIPLY_TOTAL));


    /**
     * Registers the mod's mob effects with the Minecraft Forge event bus.
     * This method is called during the mod initialization phase.
     *
     * @param eventBus The Forge event bus where the effects will be registered.
     */
    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
