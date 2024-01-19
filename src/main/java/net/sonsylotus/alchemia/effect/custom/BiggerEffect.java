package net.sonsylotus.alchemia.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

//
//import net.minecraft.world.effect.MobEffect;
//import net.minecraft.world.effect.MobEffectCategory;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.ai.attributes.AttributeMap;
//import virtuoel.pehkui.api.ScaleData;
//import virtuoel.pehkui.api.ScaleType;
//
public class BiggerEffect extends MobEffect {
    protected BiggerEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }
}

//public class BiggerEffect extends MobEffect {
//    private final ScaleType scaleType;
//
//    protected BiggerEffect(MobEffectCategory pCategory, int pColor, ScaleType scaleType) {
//        super(pCategory, pColor);
//        this.scaleType = scaleType;
//    }
//
//    @Override
//    public void applyEffectTick(LivingEntity entity, int amplifier) {
//        ScaleData scaleData = scaleType.getScaleData(entity);
//        double newScale = (amplifier + 1) * 2; // Adjust the scaling factor as needed
//        newScale = Math.min(newScale, 10); // Example max size, adjust as needed
//        scaleData.setTargetScale((float) newScale);
//        scaleData.setScaleTickDelay(scaleData.getScaleTickDelay());
//
//        super.applyEffectTick(entity, amplifier);
//    }
//
//    @Override
//    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributes, int amplifier) {
//        ScaleData scaleData = scaleType.getScaleData(entity);
//        scaleData.setTargetScale(1.0F); // Reset to normal size
//        scaleData.setScaleTickDelay(scaleData.getScaleTickDelay());
//    }
//
//    @Override
//    public boolean isDurationEffectTick(int duration, int amplifier) {
//        // Implement logic to determine when to update the effect
//        return duration % 20 == 0; // Example: Update every second (20 ticks)
//    }
//}
