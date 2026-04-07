package io.boterop.sbmobsarmor.entities;

import io.boterop.sbmobsarmor.init.EntitiesInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BoneArrow extends AbstractArrow {
    private boolean isWither;

    public BoneArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    public BoneArrow(Level level, LivingEntity shooter, boolean isWither) {
        super(EntitiesInit.BONE_ARROW.value(), shooter, level, ItemStack.EMPTY, null);
        this.isWither = isWither;
    }

    @Override
    protected void doPostHurtEffects(LivingEntity target) {
        super.doPostHurtEffects(target);
        if (isWither) {
            target.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
        }
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return ItemStack.EMPTY;
    }
}