package io.boterop.sbmobsarmor.init;

import io.boterop.sbmobsarmor.SBMobsArmor;
import io.boterop.sbmobsarmor.blocks.BlockBase;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;


public class BlocksInit {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SBMobsArmor.MODID);

    public static final DeferredBlock<Block> ROTTEN_FLESH = BLOCKS.register("rotten_flesh_block", registryName -> new BlockBase(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, registryName))
            .mapColor(MapColor.COLOR_BROWN)
            .strength(0.5f, 0.5f)
            .sound(SoundType.SLIME_BLOCK)
            .randomTicks()
            .noOcclusion()
            .friction(0.4f)
            .jumpFactor(0.7f)
    ));
}