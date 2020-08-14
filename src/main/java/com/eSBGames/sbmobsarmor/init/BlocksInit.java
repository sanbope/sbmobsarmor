package com.eSBGames.sbmobsarmor.init;

import java.util.ArrayList;
import java.util.List;

import com.eSBGames.sbmobsarmor.blocks.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlocksInit
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ROTTEN_FLESH_BLOCK = new BlockBase("rotten_flesh_block", Material.CLOTH);
}
