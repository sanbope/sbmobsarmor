package io.boterop.sbmobsarmor.items;

import io.boterop.sbmobsarmor.init.ItemsInit;
import io.boterop.sbmobsarmor.util.IHasModel;
import io.boterop.sbmobsarmor.SBMobsArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);

		ItemsInit.ITEMS.add(this);
	}

	@Override
	public void registerModels()
	{
		SBMobsArmor.proxy.registerItemRenderer(this, 0, "inventory");
	}

}