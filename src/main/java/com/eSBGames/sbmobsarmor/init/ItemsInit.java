package com.eSBGames.sbmobsarmor.init;

import java.util.List;

import com.eSBGames.sbmobsarmor.items.tools.ToolAxe;
import com.eSBGames.sbmobsarmor.items.tools.ToolBow;
import com.eSBGames.sbmobsarmor.items.tools.ToolHoe;
import com.eSBGames.sbmobsarmor.items.tools.ToolPickaxe;
import com.eSBGames.sbmobsarmor.items.tools.ToolSpade;
import com.eSBGames.sbmobsarmor.items.tools.ToolSword;

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
	
	//skeleton
	public static final ToolMaterial MATERIAL_BONE = EnumHelper.addToolMaterial("", 2, 150, 6.0F, 2F, 14);
	public static final ItemSword BONE_SWORD = new ToolSword("bone_sword", MATERIAL_BONE);
	public static final ItemSpade BONE_SHOVEL = new ToolSpade("bone_shovel", MATERIAL_BONE);
	public static final ItemPickaxe BONE_PICKAXE = new ToolPickaxe("bone_pickaxe", MATERIAL_BONE);
	public static final ItemAxe BONE_AXE = new ToolAxe("bone_axe", MATERIAL_BONE, 3f, -3.2f);
	public static final ItemHoe BONE_HOE = new ToolHoe("bone_hoe", MATERIAL_BONE);
	public static final ItemBow BONE_BOW = new ToolBow("bone_bow", MATERIAL_BONE);
}