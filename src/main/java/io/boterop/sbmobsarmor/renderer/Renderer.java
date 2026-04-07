package io.boterop.sbmobsarmor.renderer;

import io.boterop.sbmobsarmor.init.EntitiesInit;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class Renderer {
    public static void register(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(
                EntitiesInit.BONE_ARROW.value(),
                BoneArrowRenderer::new
        );
    }
}
