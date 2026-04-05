package io.boterop.sbmobsarmor;

import io.boterop.sbmobsarmor.init.BlocksInit;
import io.boterop.sbmobsarmor.init.ItemsInit;
import io.boterop.sbmobsarmor.tabs.BlocksTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(SBMobsArmor.MODID)
public class SBMobsArmor {
	public static final String MODID = "sbmobsarmor";

	public SBMobsArmor(IEventBus modEventBus) {
		BlocksInit.BLOCKS.register(modEventBus);
		ItemsInit.ITEMS.register(modEventBus);
		BlocksTab.TABS.register(modEventBus);
	}
}