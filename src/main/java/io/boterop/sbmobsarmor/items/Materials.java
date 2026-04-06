package io.boterop.sbmobsarmor.items;

import io.boterop.sbmobsarmor.SBMobsArmor;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.neoforged.neoforge.common.Tags;

import java.util.EnumMap;

public class Materials {
    public static final ArmorMaterial ROTTEN_FLESH_MATERIAL = create(
            "rotten_flesh",
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 4);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 4);
            }),
            1,
            1,
            0,
            0,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            Tags.Items.INGOTS_COPPER);

    private static ArmorMaterial create(String name, EnumMap<ArmorType, Integer> defense, int durability, int enchantability, float toughness, float knockbackResistance, Holder<SoundEvent> equipSound, TagKey<Item> repairItem) {
        ResourceKey<EquipmentAsset> asset = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(SBMobsArmor.MODID, name));

        return new ArmorMaterial(durability, defense, enchantability, equipSound, toughness, knockbackResistance, repairItem, asset);
    }
}
