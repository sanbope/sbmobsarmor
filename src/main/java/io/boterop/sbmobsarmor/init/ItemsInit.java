package io.boterop.sbmobsarmor.init;

import io.boterop.sbmobsarmor.SBMobsArmor;
import io.boterop.sbmobsarmor.items.BoneBow;
import io.boterop.sbmobsarmor.items.Materials;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemsInit {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(SBMobsArmor.MODID);

    public static final DeferredItem<BlockItem> ROTTEN_FLESH_ITEM =
            ITEMS.register("rotten_flesh_block", registryName -> new BlockItem(BlocksInit.ROTTEN_FLESH.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));

    //zombie
    public static final DeferredItem<Item>[] ROTTEN_FLESH_ARMOR = registerEntireArmor("rotten_flesh", Materials.ROTTEN_FLESH_MATERIAL);

    //skeleton
    public static final DeferredItem<Item>[] BONE_ARMOR = registerEntireArmor("bone", Materials.BONE_MATERIAL);
    public static final DeferredItem<Item> BONE_BOW = ITEMS.registerItem("bone_bow", props -> new BoneBow(props.durability(384).enchantable(1)));

    private static DeferredItem<Item>[] registerEntireArmor(String name, ArmorMaterial material) {
        return new DeferredItem[]{
                registerArmor(name + "_helmet", material, ArmorType.HELMET),
                registerArmor(name + "_chestplate", material, ArmorType.CHESTPLATE),
                registerArmor(name + "_leggings", material, ArmorType.LEGGINGS),
                registerArmor(name + "_boots", material, ArmorType.BOOTS)
        };
    }

    private static DeferredItem<Item> registerArmor(String name, ArmorMaterial material, ArmorType type) {
        return ITEMS.registerItem(name, props -> new Item(props.humanoidArmor(material, type)));
    }

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