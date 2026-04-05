package com.eSBGames.sbmobsarmor.items.other;

import com.eSBGames.sbmobsarmor.SBMobsArmor;
import com.eSBGames.sbmobsarmor.init.ItemsInit;
import com.eSBGames.sbmobsarmor.items.EnderPearlBase;
import com.eSBGames.sbmobsarmor.items.armor.ArmorBase;
import com.eSBGames.sbmobsarmor.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class EnderStick extends ItemEnderPearl implements IHasModel
{
	public EnderStick(String name)
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);
		setMaxStackSize(1);

		ItemsInit.ITEMS.add(this);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		if (ArmorBase.hasFullArmor(playerIn, "ender"))
		{
			//itemstack.shrink(1);

			worldIn.playSound((EntityPlayer) null, playerIn.posX, playerIn.posY, playerIn.posZ,
					SoundEvents.ENTITY_ENDERPEARL_THROW, SoundCategory.NEUTRAL, 0.5F,
					0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			playerIn.getCooldownTracker().setCooldown(this, 20);

			if (!worldIn.isRemote)
			{
				EnderPearlBase entityenderpearl = new EnderPearlBase(worldIn, playerIn);
				entityenderpearl.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
				worldIn.spawnEntity(entityenderpearl);
			}

			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		}
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
	}

	@Override
	public void registerModels()
	{
		SBMobsArmor.proxy.registerItemRenderer(this, 0, "inventory");
	}

}