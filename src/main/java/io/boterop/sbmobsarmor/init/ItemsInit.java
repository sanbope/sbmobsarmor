package io.boterop.sbmobsarmor.init;

import io.boterop.sbmobsarmor.SBMobsArmor;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemsInit {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(SBMobsArmor.MODID);

    public static final Supplier<BlockItem> ROTTEN_FLESH_ITEM =
            ITEMS.registerSimpleBlockItem("rotten_flesh_block", BlocksInit.ROTTEN_FLESH);

//	//zombie
//	public static final ArmorMaterial ARMOR_MATERIAL_ROTTEN_FLESH = EnumHelper.addArmorMaterial("armor_material_rotten_flesh", SBMobsArmor.MODID + ":rotten_flesh", 5, new int[] {1, 2, 3, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
//	public static final Item ROTTEN_FLESH_HELMET = new ArmorBase("rotten_flesh_helmet", ARMOR_MATERIAL_ROTTEN_FLESH, 1, EntityEquipmentSlot.HEAD);
//	public static final Item ROTTEN_FLESH_CHESTPLATE = new ArmorBase("rotten_flesh_chestplate", ARMOR_MATERIAL_ROTTEN_FLESH, 1, EntityEquipmentSlot.CHEST);
//	public static final Item ROTTEN_FLESH_LEGGINGS = new ArmorBase("rotten_flesh_leggings", ARMOR_MATERIAL_ROTTEN_FLESH, 2, EntityEquipmentSlot.LEGS);
//	public static final Item ROTTEN_FLESH_BOOTS = new ArmorBase("rotten_flesh_boots", ARMOR_MATERIAL_ROTTEN_FLESH, 1, EntityEquipmentSlot.FEET);
//
//	//skeleton
//	public static final ToolMaterial MATERIAL_BONE = EnumHelper.addToolMaterial("material_bone", 2, 59, 6.0F, 2.0F, 14);
//	public static final ItemSword BONE_SWORD = new ToolSword("bone_sword", MATERIAL_BONE);
//	public static final ItemSpade BONE_SHOVEL = new ToolSpade("bone_shovel", MATERIAL_BONE);
//	public static final ItemPickaxe BONE_PICKAXE = new ToolPickaxe("bone_pickaxe", MATERIAL_BONE);
//	public static final ItemAxe BONE_AXE = new ToolAxe("bone_axe", MATERIAL_BONE, 3f, -3.2f);
//	public static final ItemHoe BONE_HOE = new ToolHoe("bone_hoe", MATERIAL_BONE);
//	public static final ItemBow BONE_BOW = new ToolBow("bone_bow", MATERIAL_BONE);
//
//	public static final ArmorMaterial ARMOR_MATERIAL_BONE = EnumHelper.addArmorMaterial("armor_material_bone", SBMobsArmor.MODID + ":bone", 15, new int[] {2, 5, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
//	public static final Item BONE_HELMET = new ArmorBase("bone_helmet", ARMOR_MATERIAL_BONE, 1, EntityEquipmentSlot.HEAD);
//	public static final Item BONE_CHESTPLATE = new ArmorBase("bone_chestplate", ARMOR_MATERIAL_BONE, 1, EntityEquipmentSlot.CHEST);
//	public static final Item BONE_LEGGINGS = new ArmorBase("bone_leggings", ARMOR_MATERIAL_BONE, 2, EntityEquipmentSlot.LEGS);
//	public static final Item BONE_BOOTS = new ArmorBase("bone_boots", ARMOR_MATERIAL_BONE, 1, EntityEquipmentSlot.FEET);
//
//	//wither
//	public static final ArmorMaterial ARMOR_MATERIAL_BONE_WITHER = EnumHelper.addArmorMaterial("armor_material_bone_wither", SBMobsArmor.MODID + ":bone_wither", 15, new int[] {2, 5, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0f);
//	public static final Item BONE_WITHER_HELMET = new ArmorBase("bone_wither_helmet", ARMOR_MATERIAL_BONE_WITHER, 1, EntityEquipmentSlot.HEAD);
//	public static final Item BONE_WITHER_CHESTPLATE = new ArmorBase("bone_wither_chestplate", ARMOR_MATERIAL_BONE_WITHER, 1, EntityEquipmentSlot.CHEST);
//	public static final Item BONE_WITHER_LEGGINGS = new ArmorBase("bone_wither_leggings", ARMOR_MATERIAL_BONE_WITHER, 2, EntityEquipmentSlot.LEGS);
//	public static final Item BONE_WITHER_BOOTS = new ArmorBase("bone_wither_boots", ARMOR_MATERIAL_BONE_WITHER, 1, EntityEquipmentSlot.FEET);
//
//	//ender
//	public static final ArmorMaterial ARMOR_MATERIAL_ENDER = EnumHelper.addArmorMaterial("armor_material_ender", SBMobsArmor.MODID + ":ender", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 2f);
//	public static final Item ENDER_HELMET = new ArmorBase("ender_helmet", ARMOR_MATERIAL_ENDER, 1, EntityEquipmentSlot.HEAD);
//	public static final Item ENDER_CHESTPLATE = new ArmorBase("ender_chestplate", ARMOR_MATERIAL_ENDER, 1, EntityEquipmentSlot.CHEST);
//	public static final Item ENDER_LEGGINGS = new ArmorBase("ender_leggings", ARMOR_MATERIAL_ENDER, 2, EntityEquipmentSlot.LEGS);
//	public static final Item ENDER_BOOTS = new ArmorBase("ender_boots", ARMOR_MATERIAL_ENDER, 1, EntityEquipmentSlot.FEET);
//
//	public static final Item ENDER_STICK = new EnderStick("ender_stick");
}