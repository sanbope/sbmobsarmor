package io.boterop.sbmobsarmor.tabs;

import io.boterop.sbmobsarmor.SBMobsArmor;
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

    public static final Supplier<CreativeModeTab> TAB = TABS.register("blocks_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("SB Mobs Armor"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .icon(() -> new ItemStack(ItemsInit.ROTTEN_FLESH_ITEM.get()))
                    .displayItems((params, output) -> {
                        output.accept(ItemsInit.ROTTEN_FLESH_ITEM.get());
                    })
                    .build()
    );
}
