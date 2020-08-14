package com.eSBGames.sbmobsarmor.items.armor;

import com.eSBGames.sbmobsarmor.SBMobsArmor;
import com.eSBGames.sbmobsarmor.init.ItemsInit;
import com.eSBGames.sbmobsarmor.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements IHasModel
{
	private String name;
	
	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		this.name = name;

		ItemsInit.ITEMS.add(this);
	}
	
	public String getName()
	{
		return name;
	}

	@Override
	public void registerModels()
	{
		SBMobsArmor.proxy.registerItemRenderer(this, 0, "inventory");
	}

}