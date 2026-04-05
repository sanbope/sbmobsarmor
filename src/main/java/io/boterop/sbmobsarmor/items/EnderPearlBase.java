package com.eSBGames.sbmobsarmor.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEndGateway;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EnderPearlBase extends EntityEnderPearl
{
	private EntityLivingBase perlThrower;

	public EnderPearlBase(World worldIn, EntityLivingBase throwerIn)
	{
		super(worldIn, throwerIn);
		perlThrower = throwerIn;
	}

	@Override
	protected void onImpact(RayTraceResult result)
	{
		EntityLivingBase entitylivingbase = this.getThrower();

		if (result.entityHit != null)
		{
			if (result.entityHit == this.perlThrower)
			{
				return;
			}

			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, entitylivingbase), 0.0F);
		}

		if (result.typeOfHit == RayTraceResult.Type.BLOCK)
		{
			BlockPos blockpos = result.getBlockPos();
			TileEntity tileentity = this.world.getTileEntity(blockpos);

			if (tileentity instanceof TileEntityEndGateway)
			{
				TileEntityEndGateway tileentityendgateway = (TileEntityEndGateway) tileentity;

				if (entitylivingbase != null)
				{
					if (entitylivingbase instanceof EntityPlayerMP)
					{
						CriteriaTriggers.ENTER_BLOCK.trigger((EntityPlayerMP) entitylivingbase,
								this.world.getBlockState(blockpos));
					}

					tileentityendgateway.teleportEntity(entitylivingbase);
					this.setDead();
					return;
				}

				tileentityendgateway.teleportEntity(this);
				return;
			}
		}

		for (int i = 0; i < 32; ++i)
		{
			this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX, this.posY + this.rand.nextDouble() * 2.0D,
					this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
		}

		if (!this.world.isRemote)
		{
			if (entitylivingbase instanceof EntityPlayerMP)
			{
				EntityPlayerMP entityplayermp = (EntityPlayerMP) entitylivingbase;

				if (entityplayermp.connection.getNetworkManager().isChannelOpen() && entityplayermp.world == this.world
						&& !entityplayermp.isPlayerSleeping())
				{
					net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(
							entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
					if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
					{
						if (entitylivingbase.isRiding())
						{
							entitylivingbase.dismountRidingEntity();
						}

						entitylivingbase.setPositionAndUpdate(event.getTargetX(), event.getTargetY(),
								event.getTargetZ());
						entitylivingbase.fallDistance = 0.0F;
						entitylivingbase.attackEntityFrom(DamageSource.FALL, event.getAttackDamage());
					}
				}
			} else if (entitylivingbase != null)
			{
				entitylivingbase.setPositionAndUpdate(this.posX, this.posY, this.posZ);
				entitylivingbase.fallDistance = 0.0F;
			}

			this.setDead();
		}
	}

}