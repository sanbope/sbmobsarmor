package io.boterop.sbmobsarmor;

import io.boterop.sbmobsarmor.events.RottenFleshEvents;
import io.boterop.sbmobsarmor.init.BlocksInit;
import io.boterop.sbmobsarmor.init.EntitiesInit;
import io.boterop.sbmobsarmor.init.ItemsInit;
import io.boterop.sbmobsarmor.renderer.Renderer;
import io.boterop.sbmobsarmor.tabs.ArmorTab;
import io.boterop.sbmobsarmor.tabs.BlocksTab;
import io.boterop.sbmobsarmor.tabs.CombatTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(SBMobsArmor.MODID)
public class SBMobsArmor {
    public static final String MODID = "sbmobsarmor";

    public SBMobsArmor(IEventBus modEventBus) {
        modEventBus.addListener(Renderer::register);

        EntitiesInit.ENTITIES.register(modEventBus);
        BlocksInit.BLOCKS.register(modEventBus);
        ItemsInit.ITEMS.register(modEventBus);

        BlocksTab.TABS.register(modEventBus);
        ArmorTab.TABS.register(modEventBus);
        CombatTab.TABS.register(modEventBus);


        NeoForge.EVENT_BUS.register(RottenFleshEvents.class);
    }
}