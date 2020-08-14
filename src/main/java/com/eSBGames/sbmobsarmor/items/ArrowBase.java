package com.eSBGames.sbmobsarmor.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ArrowBase extends Item
{
	private boolean isWither;

	public ArrowBase(boolean isWither)
	{
		this.isWither = isWither;
		this.setCreativeTab(CreativeTabs.COMBAT);
	}

	public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
	{
		EntityTippedArrow entitytippedarrow = new EntityTippedArrow(worldIn, shooter);
		entitytippedarrow.setPotionEffect(stack);

		if (isWither)
		{
			int seconds = 10;
			entitytippedarrow.addEffect(new PotionEffect(MobEffects.WITHER, seconds * 20, 0, false, true)); // Add custom PotionEffect
		}
		return entitytippedarrow;
	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player)
	{
		return true;
	}
}