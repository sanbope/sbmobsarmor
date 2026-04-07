package io.boterop.sbmobsarmor.tabs;

import io.boterop.sbmobsarmor.SBMobsArmor;
import io.boterop.sbmobsarmor.init.ItemsInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.function.Supplier;

public class ArmorTab {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, SBMobsArmor.MODID);

    public static final Supplier<CreativeModeTab> TAB = TABS.register("armor_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("SB Mobs Armor"))
                    .withTabsBefore(Identifier.fromNamespaceAndPath(SBMobsArmor.MODID, "blocks_tab"))
                    .icon(() -> new ItemStack(ItemsInit.ROTTEN_FLESH_ARMOR[0].get()))
                    .displayItems((params, output) -> {
                        Arrays.stream(ItemsInit.ROTTEN_FLESH_ARMOR).forEach(item -> output.accept(item.get()));
                        Arrays.stream(ItemsInit.BONE_ARMOR).forEach(item -> output.accept(item.get()));
                    })
                    .build()
    );
}
