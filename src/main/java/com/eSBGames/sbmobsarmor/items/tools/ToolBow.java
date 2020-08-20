package com.eSBGames.sbmobsarmor.items.tools;

import java.util.ArrayList;
import java.util.List;

import com.eSBGames.sbmobsarmor.SBMobsArmor;
import com.eSBGames.sbmobsarmor.init.ItemsInit;
import com.eSBGames.sbmobsarmor.items.ArrowBase;
import com.eSBGames.sbmobsarmor.items.armor.ArmorBase;
import com.eSBGames.sbmobsarmor.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ToolBow extends ItemBow implements IHasModel
{
	private boolean isWither = false;

	public ToolBow(String name, ToolMaterial material)
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);

		ItemsInit.ITEMS.add(this);
	}

	protected ItemStack findAmmo(EntityPlayer player)
	{

		List<ItemStack> armorList = new ArrayList<ItemStack>();

		for (ItemStack i : player.getArmorInventoryList())
		{
			armorList.add(i);
		}

		isWither = ArmorBase.hasFullArmor(player, "wither");

		if (ArmorBase.hasFullArmor(player, "bone"))
		{
			ItemStack itemStack = new ItemStack(new ArrowBase(isWither));
			return itemStack;
		}

		if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND)))
		{
			return player.getHeldItem(EnumHand.OFF_HAND);
		} else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND)))
		{
			return player.getHeldItem(EnumHand.MAIN_HAND);
		} else
		{
			for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
			{
				ItemStack itemstack = player.inventory.getStackInSlot(i);

				if (this.isArrow(itemstack))
				{
					return itemstack;
				}
			}

			return ItemStack.EMPTY;
		}
	}

	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
	{
		if (entityLiving instanceof EntityPlayer)
		{
			EntityPlayer entityplayer = (EntityPlayer) entityLiving;
			boolean flag = entityplayer.capabilities.isCreativeMode
					|| EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = this.findAmmo(entityplayer);

			int i = this.getMaxItemUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i,
					!itemstack.isEmpty() || flag);
			if (i < 0)
				return;

			if (!itemstack.isEmpty() || flag)
			{
				if (itemstack.isEmpty())
				{
					itemstack = new ItemStack(Items.ARROW);
				}

				float f = getArrowVelocity(i);

				if ((double) f >= 0.1D)
				{
					boolean flag1 = entityplayer.capabilities.isCreativeMode
							|| (itemstack.getItem() instanceof ArrowBase);

					if (!worldIn.isRemote)
					{
						ArrowBase itemarrow = (ArrowBase) (itemstack.getItem() instanceof ArrowBase
								? itemstack.getItem()
								: Items.ARROW);
						EntityArrow entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);
						entityarrow = this.customizeArrow(entityarrow);
						entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F,
								f * 3.0F, 1.0F);

						if (f == 1.0F || isWither)
						{
							entityarrow.setIsCritical(true);
						}

						int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

						if (j > 0)
						{
							entityarrow.setDamage(entityarrow.getDamage() + (double) j * 0.5D + 0.5D);
						}

						int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);

						if (k > 0)
						{
							entityarrow.setKnockbackStrength(k);
						}

						if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
						{
							if (isWither)
							{
								entityarrow.setFire(200);
							} else
							{
								entityarrow.setFire(50);
							}
						}

						if (isWither)
						{
							entityarrow.setDamage(entityarrow.getDamage() * 2);
						} else
						{
							entityarrow.setDamage(entityarrow.getDamage() / 2);
						}

						stack.damageItem(1, entityplayer);

						if (flag1 || entityplayer.capabilities.isCreativeMode
								&& (itemstack.getItem() == Items.SPECTRAL_ARROW
										|| itemstack.getItem() == Items.TIPPED_ARROW))
						{
							entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
						}

						worldIn.spawnEntity(entityarrow);
					}

					worldIn.playSound((EntityPlayer) null, entityplayer.posX, entityplayer.posY, entityplayer.posZ,
							SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F,
							1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

					if (!flag1 && !entityplayer.capabilities.isCreativeMode)
					{
						itemstack.shrink(1);

						if (itemstack.isEmpty())
						{
							entityplayer.inventory.deleteStack(itemstack);
						}
					}

					entityplayer.addStat(StatList.getObjectUseStats(this));
				}
			}
		}
	}

	@Override
	public void registerModels()
	{
		SBMobsArmor.proxy.registerItemRenderer(this, 0, "inventory");
	}
}