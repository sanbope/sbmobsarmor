package com.eSBGames.sbmobsarmor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.eSBGames.sbmobsarmor.proxy.CommonProxy;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SBMobsArmor.MOD_ID, name = SBMobsArmor.NAME, version = SBMobsArmor.VERSION)
public class SBMobsArmor
{
	public static final String MOD_ID = "sbmobsarmor";
	public static final String NAME = "SB Mob's Armor";
	public static final String VERSION = "1.12.2";
	public static final String CLIENT_PROXY_CLASS = "com.eSBGames.sbmobsarmor.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.eSBGames.sbmobsarmor.proxy.CommonProxy";

	private static final Logger LOGGER = LogManager.getLogger();
	
	@Instance
	public static SBMobsArmor instance;

	@SidedProxy(clientSide = SBMobsArmor.CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{

	}

	@EventHandler
	public static void init(FMLInitializationEvent event)
	{

	}

	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{

	}
	
	public static EntityPlayer livingBaseToPlayer(EntityLivingBase entity)
	{
		if (entity instanceof EntityPlayer)
		{
			return (EntityPlayer) entity;
		}
		
		return null;
	}
	
	public static void print(String txt)
	{
		LOGGER.info(txt);
	}
}
