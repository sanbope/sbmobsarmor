package io.boterop.sbmobsarmor.tabs;


import io.boterop.sbmobsarmor.SBMobsArmor;
import io.boterop.sbmobsarmor.init.ItemsInit;
import io.boterop.sbmobsarmor.items.Materials;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CombatTab {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, SBMobsArmor.MODID);

    public static final Supplier<CreativeModeTab> TAB = TABS.register("combat_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("SB Mobs Armor"))
                    .withTabsBefore(Identifier.fromNamespaceAndPath(SBMobsArmor.MODID, "armor_tab"))
                    .icon(() -> new ItemStack(ItemsInit.BONE_SWORD.get()))
                    .displayItems((params, output) -> {
                        output.accept(ItemsInit.BONE_BOW.get());
                        output.accept(ItemsInit.BONE_SWORD.get());
                        output.accept(ItemsInit.BONE_SHOVEL.get());
                        output.accept(ItemsInit.BONE_PICKAXE.get());
                        output.accept(ItemsInit.BONE_AXE.get());
                        output.accept(ItemsInit.BONE_HOE.get());
                    })
                    .build()
    );
}
