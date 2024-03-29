package net.sonsylotus.alchemia.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.sonsylotus.alchemia.effect.custom.sender.ConfusionEffectEvent;

;

public class ConfusionEffect extends MobEffect {
    public ConfusionEffect(MobEffectCategory pCategory, int pColor) {

        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        ConfusionEffectEvent event = new ConfusionEffectEvent(pLivingEntity);
        MinecraftForge.EVENT_BUS.post(event);
        super.applyEffectTick(pLivingEntity, pAmplifier);


    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
