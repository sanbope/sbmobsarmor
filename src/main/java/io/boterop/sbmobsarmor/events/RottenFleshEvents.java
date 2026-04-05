package io.boterop.sbmobsarmor.events;

import io.boterop.sbmobsarmor.SBMobsArmor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import org.jline.utils.Log;


public class RottenFleshEvents
{
	@SubscribeEvent
	public static void onUpdate()
	{
		Log.debug("RottenFleshEvents.onUpdate");
//		EntityLivingBase player = SBMobsArmor.livingBaseToPlayer(event.getEntityLiving());
//
//		if (player != null)
//		{
//			if (ArmorBase.hasFullArmor(player, "rotten_flesh"))
//			{
//				FoodStats foodStats = ((EntityPlayer) player).getFoodStats();
//				foodStats.setFoodLevel(20);
//				foodStats.setFoodSaturationLevel(20);
//			}
//		}
	}

	@SubscribeEvent
	public static void onJump(LivingEvent.LivingJumpEvent event)
	{
		Log.debug("RottenFleshEvents.onJump");
//		EntityLivingBase player = SBMobsArmor.livingBaseToPlayer(event.getEntityLiving());
//
//		if (player != null)
//		{
//
//		}
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