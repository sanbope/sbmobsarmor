package io.boterop.sbmobsarmor.items;

import io.boterop.sbmobsarmor.SBMobsArmor;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

import java.util.EnumMap;

public class Materials {
    public static final ArmorMaterial ROTTEN_FLESH_ARMOR_MATERIAL = createArmorMaterial(
            "rotten_flesh",
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 1);
                map.put(ArmorType.LEGGINGS, 2);
                map.put(ArmorType.CHESTPLATE, 3);
                map.put(ArmorType.HELMET, 1);
                map.put(ArmorType.BODY, 3);
            }),
            5,
            15,
            0,
            0,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            Tags.Items.LEATHERS);

    public static final ArmorMaterial BONE_ARMOR_MATERIAL = createArmorMaterial(
            "bone",
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 5);
            }),
            15,
            9,
            0,
            0,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            Tags.Items.BONES
    );

    public static final ToolMaterial BONE_TOOL_MATERIAL = createToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, Tags.Items.BONES);

    private static ArmorMaterial createArmorMaterial(String name, EnumMap<ArmorType, Integer> defense, int durability, int enchantability, float toughness, float knockbackResistance, Holder<SoundEvent> equipSound, TagKey<Item> repairItem) {
        ResourceKey<EquipmentAsset> asset = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(SBMobsArmor.MODID, name));

        return new ArmorMaterial(durability, defense, enchantability, equipSound, toughness, knockbackResistance, repairItem, asset);
    }

    private static ToolMaterial createToolMaterial(TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float attackDamageBonus, int enchantmentValue, TagKey<Item> repairItems) {
        return new ToolMaterial(incorrectBlocksForDrops, durability, speed, attackDamageBonus, enchantmentValue, repairItems);
    }
}
