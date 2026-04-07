package io.boterop.sbmobsarmor.init;

import io.boterop.sbmobsarmor.SBMobsArmor;
import io.boterop.sbmobsarmor.entities.BoneArrow;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EntitiesInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.createEntities(SBMobsArmor.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<BoneArrow>> BONE_ARROW =
            ENTITIES.register("bone_arrow",
                    () -> EntityType.Builder
                            .<BoneArrow>of(BoneArrow::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build(
                                    ResourceKey.create(
                                            Registries.ENTITY_TYPE,
                                            Identifier.fromNamespaceAndPath(SBMobsArmor.MODID, "bone_arrow")
                                    )
                            )
            );
}