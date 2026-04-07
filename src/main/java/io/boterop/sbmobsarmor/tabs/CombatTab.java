package io.boterop.sbmobsarmor.tabs;


import io.boterop.sbmobsarmor.SBMobsArmor;
import io.boterop.sbmobsarmor.init.ItemsInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CombatTab {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, SBMobsArmor.MODID);

    public static final Supplier<CreativeModeTab> TAB = TABS.register("combat_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("SB Mobs Armor"))
                    .withTabsBefore(Identifier.fromNamespaceAndPath(SBMobsArmor.MODID, "armor_tab"))
                    .icon(() -> new ItemStack(ItemsInit.BONE_BOW.get()))
                    .displayItems((params, output) -> {
                        output.accept(ItemsInit.BONE_BOW.get());
                    })
                    .build()
    );
}
