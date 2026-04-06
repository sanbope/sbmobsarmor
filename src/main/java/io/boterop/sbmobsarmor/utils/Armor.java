package io.boterop.sbmobsarmor.utils;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;

public class Armor {
    public static String getArmor(Player player, EquipmentSlot slot) {
        return player.getItemBySlot(slot).getItem().toString();
    }

    public static boolean hasFullArmor(Player player, String armorName) {
        String head = getArmor(player, EquipmentSlot.HEAD);
        String chest = getArmor(player, EquipmentSlot.CHEST);
        String legs = getArmor(player, EquipmentSlot.LEGS);
        String feet = getArmor(player, EquipmentSlot.FEET);

        return has(armorName, head)
                && has(armorName, chest)
                && has(armorName, legs)
                && has(armorName, feet);
    }

    private static boolean has(String name, String armor) {
        return formatName(armor).equals(name);
    }

    private static String formatName(String name) {
        return name
                .toLowerCase()
                .replace("_helmet", "")
                .replace("_chestplate", "")
                .replace("_leggings", "")
                .replace("_boots", "");
    }
}
