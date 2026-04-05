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

public class ArmorTab {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, SBMobsArmor.MODID);

    public static final Supplier<CreativeModeTab> TAB = TABS.register("armor_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("SB Mobs Armor"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .icon(() -> new ItemStack(ItemsInit.ROTTEN_FLESH_HELMET.get()))
                    .displayItems((params, output) -> {
                        output.accept(ItemsInit.ROTTEN_FLESH_HELMET.get());
                        output.accept(ItemsInit.ROTTEN_FLESH_CHESTPLATE.get());
                        output.accept(ItemsInit.ROTTEN_FLESH_LEGGINGS.get());
                        output.accept(ItemsInit.ROTTEN_FLESH_BOOTS.get());
                    })
                    .build()
    );
}
