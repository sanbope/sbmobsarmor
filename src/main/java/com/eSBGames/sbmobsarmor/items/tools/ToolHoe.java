package com.eSBGames.sbmobsarmor.items.tools;

import com.eSBGames.sbmobsarmor.SBMobsArmor;
import com.eSBGames.sbmobsarmor.init.ItemsInit;
import com.eSBGames.sbmobsarmor.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe implements IHasModel
{
	public ToolHoe(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);

		ItemsInit.ITEMS.add(this);
	}

	@Override
	public void registerModels()
	{
		SBMobsArmor.proxy.registerItemRenderer(this, 0, "inventory");
	}
}