package com.eSBGames.sbmobsarmor.init;

import java.util.List;

import com.eSBGames.sbmobsarmor.SBMobsArmor;
import com.eSBGames.sbmobsarmor.items.armor.ArmorBase;
import com.eSBGames.sbmobsarmor.items.tools.ToolAxe;
import com.eSBGames.sbmobsarmor.items.tools.ToolBow;
import com.eSBGames.sbmobsarmor.items.tools.ToolHoe;
import com.eSBGames.sbmobsarmor.items.tools.ToolPickaxe;
import com.eSBGames.sbmobsarmor.items.tools.ToolSpade;
import com.eSBGames.sbmobsarmor.items.tools.ToolSword;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;

import java.util.ArrayList;

public class ItemsInit
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//zombie
	public static final ArmorMaterial ARMOR_MATERIAL_ROTTEN_FLESH = EnumHelper.addArmorMaterial("armor_material_rotten_flesh", SBMobsArmor.MOD_ID + ":rotten_flesh", 5, new int[] {1, 2, 3, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
	public static final Item ROTTEN_FLESH_HELMET = new ArmorBase("rotten_flesh_helmet", ARMOR_MATERIAL_ROTTEN_FLESH, 1, EntityEquipmentSlot.HEAD);
	public static final Item ROTTEN_FLESH_CHESTPLATE = new ArmorBase("rotten_flesh_chestplate", ARMOR_MATERIAL_ROTTEN_FLESH, 1, EntityEquipmentSlot.CHEST);
	public static final Item ROTTEN_FLESH_LEGGINGS = new ArmorBase("rotten_flesh_leggings", ARMOR_MATERIAL_ROTTEN_FLESH, 2, EntityEquipmentSlot.LEGS);
	public static final Item ROTTEN_FLESH_BOOTS = new ArmorBase("rotten_flesh_boots", ARMOR_MATERIAL_ROTTEN_FLESH, 1, EntityEquipmentSlot.FEET);
	
	//skeleton
	public static final ToolMaterial MATERIAL_BONE = EnumHelper.addToolMaterial("material_bone", 2, 59, 6.0F, 2.0F, 14);
	public static final ItemSword BONE_SWORD = new ToolSword("bone_sword", MATERIAL_BONE);
	public static final ItemSpade BONE_SHOVEL = new ToolSpade("bone_shovel", MATERIAL_BONE);
	public static final ItemPickaxe BONE_PICKAXE = new ToolPickaxe("bone_pickaxe", MATERIAL_BONE);
	public static final ItemAxe BONE_AXE = new ToolAxe("bone_axe", MATERIAL_BONE, 3f, -3.2f);
	public static final ItemHoe BONE_HOE = new ToolHoe("bone_hoe", MATERIAL_BONE);
	public static final ItemBow BONE_BOW = new ToolBow("bone_bow", MATERIAL_BONE);
	
	public static final ArmorMaterial ARMOR_MATERIAL_BONE = EnumHelper.addArmorMaterial("armor_material_bone", SBMobsArmor.MOD_ID + ":bone", 15, new int[] {2, 5, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
	public static final Item BONE_HELMET = new ArmorBase("bone_helmet", ARMOR_MATERIAL_BONE, 1, EntityEquipmentSlot.HEAD);
	public static final Item BONE_CHESTPLATE = new ArmorBase("bone_chestplate", ARMOR_MATERIAL_BONE, 1, EntityEquipmentSlot.CHEST);
	public static final Item BONE_LEGGINGS = new ArmorBase("bone_leggings", ARMOR_MATERIAL_BONE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BONE_BOOTS = new ArmorBase("bone_boots", ARMOR_MATERIAL_BONE, 1, EntityEquipmentSlot.FEET);
	
	//wither
	public static final ArmorMaterial ARMOR_MATERIAL_BONE_WITHER = EnumHelper.addArmorMaterial("armor_material_bone_wither", SBMobsArmor.MOD_ID + ":bone_wither", 15, new int[] {2, 5, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0f);
	public static final Item BONE_WITHER_HELMET = new ArmorBase("bone_wither_helmet", ARMOR_MATERIAL_BONE_WITHER, 1, EntityEquipmentSlot.HEAD);
	public static final Item BONE_WITHER_CHESTPLATE = new ArmorBase("bone_wither_chestplate", ARMOR_MATERIAL_BONE_WITHER, 1, EntityEquipmentSlot.CHEST);
	public static final Item BONE_WITHER_LEGGINGS = new ArmorBase("bone_wither_leggings", ARMOR_MATERIAL_BONE_WITHER, 2, EntityEquipmentSlot.LEGS);
	public static final Item BONE_WITHER_BOOTS = new ArmorBase("bone_wither_boots", ARMOR_MATERIAL_BONE_WITHER, 1, EntityEquipmentSlot.FEET);
}