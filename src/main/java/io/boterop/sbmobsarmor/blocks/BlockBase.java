package io.boterop.sbmobsarmor.blocks;

import io.boterop.sbmobsarmor.init.BlocksInit;
import io.boterop.sbmobsarmor.init.ItemsInit;
import io.boterop.sbmobsarmor.util.IHasModel;
import io.boterop.sbmobsarmor.SBMobsArmor;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{

	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		BlocksInit.BLOCKS.add(this);
		ItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels()
	{
		SBMobsArmor.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
}
