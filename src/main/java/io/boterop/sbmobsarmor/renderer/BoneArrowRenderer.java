package io.boterop.sbmobsarmor.renderer;

import io.boterop.sbmobsarmor.entities.BoneArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;

public class BoneArrowRenderer extends ArrowRenderer<BoneArrow, ArrowRenderState> {

    public BoneArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }

    @Override
    protected Identifier getTextureLocation(ArrowRenderState arrowRenderState) {
        return Identifier.fromNamespaceAndPath(
                "minecraft",
                "textures/entity/projectiles/arrow.png"
        );
    }
}