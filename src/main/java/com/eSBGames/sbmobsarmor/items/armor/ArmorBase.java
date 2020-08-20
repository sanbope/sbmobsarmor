package com.eSBGames.sbmobsarmor.items.armor;

import java.util.ArrayList;
import java.util.List;

import com.eSBGames.sbmobsarmor.SBMobsArmor;
import com.eSBGames.sbmobsarmor.init.ItemsInit;
import com.eSBGames.sbmobsarmor.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

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

	public boolean isThisArmor(String name)
	{
		return this.name.contains(name);
	}

	public static boolean hasFullArmor(EntityLivingBase player, String name)
	{
		int count = 0;
		String name2;

		List<ItemStack> armorList = new ArrayList<ItemStack>();

		for (ItemStack i : player.getArmorInventoryList())
		{
			armorList.add(i);
		}

		for (int i = 0; i < armorList.size(); i++)
		{
			if (armorList.get(i).getItem() instanceof ArmorBase)
			{
				name2 = ((ArmorBase) armorList.get(i).getItem()).getName();
				if (name2.contains(name))
				{
					count++;
				}
			}
		}

		return count >= 4;
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