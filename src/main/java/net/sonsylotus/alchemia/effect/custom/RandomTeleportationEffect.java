package net.sonsylotus.alchemia.effect.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class RandomTeleportationEffect extends MobEffect {
    public RandomTeleportationEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        Level pLevel = pLivingEntity.level();

        if (!pLevel.isClientSide) {
            for (int i = 0; i < 16; ++i) {
                Vec3 randomPosition = generateRandomPosition(pLivingEntity, pLevel);
                double d3 = randomPosition.x;
                double d4 = randomPosition.y;
                double d5 = randomPosition.z;

                if (pLivingEntity.isPassenger()) {
                    pLivingEntity.stopRiding();
                }

                if (pLivingEntity.randomTeleport(d3, d4, d5, true)) {
                    pLevel.gameEvent(GameEvent.TELEPORT, pLivingEntity.position(), GameEvent.Context.of(pLivingEntity));
                    break;
                }
            }
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    private Vec3 generateRandomPosition(LivingEntity entity, Level level) {
        double x = entity.getX() + (entity.getRandom().nextDouble() - 0.5) * 16.0;
        double y = Mth.clamp(entity.getY() + (double) (entity.getRandom().nextInt(16) - 8),
                (double) level.getMinBuildHeight(),
                (double) (level.getMinBuildHeight() + ((ServerLevel) level).getLogicalHeight() - 1));
        double z = entity.getZ() + (entity.getRandom().nextDouble() - 0.5) * 16.0;

        return new Vec3(x, y, z);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
