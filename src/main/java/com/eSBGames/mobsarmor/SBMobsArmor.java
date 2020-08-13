package com.eSBGames.mobsarmor;

import com.eSBGames.mobsarmor.proxy.CommonProxy;

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
	public static final String CLIENT_PROXY_CLASS = "com.eSBGames.mobsarmor.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.eSBGames.mobsarmor.proxy.CommonProxy";

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
}
