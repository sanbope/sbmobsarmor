package io.boterop.sbmobsarmor.items;

import io.boterop.sbmobsarmor.entities.BoneArrow;
import io.boterop.sbmobsarmor.utils.Armor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;

public class BoneBow extends BowItem {
    public BoneBow(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        boolean hasBoneArmor = Armor.hasFullArmor(player, "sbmobsarmor:bone");
        if (!hasBoneArmor) {
            return super.use(level, player, hand);
        }

        ItemStack itemStack = player.getItemInHand(hand);

        InteractionResult ret = EventHooks.onArrowNock(itemStack, level, player, hand, true);
        if (ret != null) {
            return ret;
        }

        player.startUsingItem(hand);
        return InteractionResult.CONSUME;
    }

    @Override
    public boolean releaseUsing(ItemStack itemStack, Level level, LivingEntity entity, int remainingTime) {
        if (entity instanceof Player player) {
            boolean isWitherArmor = Armor.hasFullArmor(player, "sbmobsarmor:wither");
            boolean hasBoneArmor = Armor.hasFullArmor(player, "sbmobsarmor:bone") || isWitherArmor;

            if (!hasBoneArmor) {
                return super.releaseUsing(itemStack, level, entity, remainingTime);
            }

            int timeHeld = this.getUseDuration(itemStack, entity) - remainingTime;
            timeHeld = EventHooks.onArrowLoose(itemStack, level, player, timeHeld, true);
            if (timeHeld < 0) {
                return false;
            } else {
                float pow = getPowerForTime(timeHeld);
                if ((double) pow < 0.1) {
                    return false;
                } else {
                    if (level instanceof ServerLevel serverLevel) {
                        BoneArrow arrow = new BoneArrow(serverLevel, player, isWitherArmor);

                        arrow.shootFromRotation(
                                player,
                                player.getXRot(),
                                player.getYRot(),
                                0.0F,
                                pow * 3.0F,
                                1.0F
                        );

                        arrow.pickup = BoneArrow.Pickup.DISALLOWED;

                        serverLevel.addFreshEntity(arrow);
                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + pow * 0.5F);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    itemStack.hurtAndBreak(1, player, player.getUsedItemHand().asEquipmentSlot());
                    return true;
                }
            }
        } else {
            return false;
        }
    }
}
