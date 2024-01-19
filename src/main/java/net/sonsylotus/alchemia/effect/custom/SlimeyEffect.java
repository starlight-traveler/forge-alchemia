package net.sonsylotus.alchemia.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class SlimeyEffect extends MobEffect {
    public SlimeyEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        if(pLivingEntity.horizontalCollision) {

            Vec3 initalVec = pLivingEntity.getDeltaMovement();
            Vec3 climbVec = new Vec3(initalVec.x, 0.2, initalVec.z);

            pLivingEntity.setDeltaMovement(climbVec.x * 0.91D, climbVec.y * 0.98D, climbVec.z * 0.91D);

        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

}
