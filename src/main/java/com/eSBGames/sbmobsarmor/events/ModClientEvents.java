package com.eSBGames.sbmobsarmor.events;

import com.eSBGames.sbmobsarmor.SBMobsArmor;
import com.eSBGames.sbmobsarmor.items.armor.ArmorBase;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.FoodStats;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = SBMobsArmor.MOD_ID)
public class ModClientEvents
{
	@SubscribeEvent
	public static void onUpdate(LivingEvent.LivingUpdateEvent event)
	{
		EntityLivingBase player = SBMobsArmor.livingBaseToPlayer(event.getEntityLiving());

		if (player != null)
		{
			if (ArmorBase.hasFullArmor(player, "rotten_flesh"))
			{
				FoodStats foodStats = ((EntityPlayer) player).getFoodStats();
				foodStats.setFoodLevel(20);
				foodStats.setFoodSaturationLevel(20);
			}
		}
	}

	public static void onJump(LivingEvent.LivingJumpEvent event)
	{
		EntityLivingBase player = SBMobsArmor.livingBaseToPlayer(event.getEntityLiving());

		if (player != null)
		{

		}
	}

//	public static void onDamagemob(AttackEntityEvent event)
//	{
//		if (event.getTarget().isEntityAlive())
//		{
//			EntityLivingBase entity = (EntityLivingBase) event.getTarget();
//			if (entity.getHealth() < 5)
//			{
//				
//			}
//		}
//	}
}