package io.boterop.sbmobsarmor.tabs;


import io.boterop.sbmobsarmor.SBMobsArmor;
import io.boterop.sbmobsarmor.init.BlocksInit;
import io.boterop.sbmobsarmor.init.ItemsInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlocksTab {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, SBMobsArmor.MODID);

    public static final Supplier<CreativeModeTab> MAIN_TAB = TABS.register("main_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("SB Mobs Armor"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> new ItemStack(BlocksInit.ROTTEN_FLESH.get()))
                    .displayItems((params, output) -> {
                        output.accept(BlocksInit.ROTTEN_FLESH.get());
                    })
                    .build()
    );
}
