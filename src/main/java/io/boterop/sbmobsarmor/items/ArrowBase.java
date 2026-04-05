package io.boterop.sbmobsarmor.items;


import net.minecraft.world.item.Item;

public class ArrowBase extends Item
{
	private final boolean isWither;

	public ArrowBase(boolean isWither, Properties props)
	{
        super(props);
        this.isWither = isWither;
//		this.setCreativeTab(CreativeTabs.COMBAT);
	}

//	public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
//	{
//		EntityTippedArrow entitytippedarrow = new EntityTippedArrow(worldIn, shooter);
//		entitytippedarrow.setPotionEffect(stack);
//
//		if (isWither)
//		{
//			int seconds = 10;
//			entitytippedarrow.addEffect(new PotionEffect(MobEffects.WITHER, seconds * 20, 0, false, true)); // Add custom PotionEffect
//		}
//		return entitytippedarrow;
//	}
//
//	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player)
//	{
//		return true;
//	}
}