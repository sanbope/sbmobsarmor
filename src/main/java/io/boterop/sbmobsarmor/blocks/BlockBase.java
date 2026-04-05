package io.boterop.sbmobsarmor.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.Block;

public class BlockBase extends Block {
    public static final MapCodec<BlockBase> CODEC = simpleCodec(BlockBase::new);

    public BlockBase(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<? extends Block> codec() {
        return CODEC;
    }
}