package net.sonsylotus.alchemia.effect.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.List;

public class HarmfulAuraEffect extends MobEffect {
    public HarmfulAuraEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        Level level = pLivingEntity.level();

        if (level instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel) level;

            // Define the radius for the poison effect
            double radius = 10.0;

            // Find and apply poison to all nearby living entities within the radius
            List<LivingEntity> nearbyEntities = serverLevel.getEntitiesOfClass(
                    LivingEntity.class,
                    pLivingEntity.getBoundingBox().inflate(radius),
                    e -> e != pLivingEntity // Exclude the entity with the DeadlyAuraEffect
            );

            MobEffectInstance poisonEffect = new MobEffectInstance(MobEffects.POISON,
                    200, 0); // 200 ticks (10 seconds) of poison

            for (LivingEntity entity : nearbyEntities) {
                entity.addEffect(poisonEffect);
            }
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        // Apply the effect every 40 ticks as an example
        return pDuration % 200 == 0;
    }
}
