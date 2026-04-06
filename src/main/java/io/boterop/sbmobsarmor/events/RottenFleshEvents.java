package io.boterop.sbmobsarmor.events;

import io.boterop.sbmobsarmor.utils.Armor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

public class RottenFleshEvents {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if (player.level().isClientSide()) return;

        if (Armor.hasFullArmor(player, "sbmobsarmor:rotten_flesh")) {
            FoodData foodData = player.getFoodData();
            foodData.setFoodLevel(10);
            foodData.setSaturation(20);
        }
    }
}