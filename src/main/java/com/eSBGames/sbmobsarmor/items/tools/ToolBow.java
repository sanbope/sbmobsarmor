package com.eSBGames.sbmobsarmor.items.tools;

import com.eSBGames.sbmobsarmor.SBMobsArmor;
import com.eSBGames.sbmobsarmor.init.ItemsInit;
import com.eSBGames.sbmobsarmor.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;

public class ToolBow extends ItemBow implements IHasModel
{
	public ToolBow(String name, ToolMaterial material)
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);

		ItemsInit.ITEMS.add(this);
	}
	
	protected ItemStack findAmmo(EntityPlayer player)
	{
		ItemStack itemstack = new ItemStack(new ItemArrow());
		return itemstack;
	}

	@Override
	public void registerModels()
	{
		SBMobsArmor.proxy.registerItemRenderer(this, 0, "inventory");
	}
}