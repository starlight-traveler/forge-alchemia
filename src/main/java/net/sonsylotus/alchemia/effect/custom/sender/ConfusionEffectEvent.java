package net.sonsylotus.alchemia.effect.custom.sender;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.Event;

public class ConfusionEffectEvent extends Event {
    private final LivingEntity affectedEntity;

    public ConfusionEffectEvent(LivingEntity entity) {
        this.affectedEntity = entity;
    }

    public LivingEntity getAffectedEntity() {
        return affectedEntity;
    }
}