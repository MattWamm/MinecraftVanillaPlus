package com.vanilla.potions.vanillapotionsplus.mixins;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(LivingEntityRenderer.class)
public interface LivingEntityRendererInvoker<T extends LivingEntity, M extends EntityModel<T>> {


    @Accessor
    List<FeatureRenderer> getFeatures();

    @Invoker("scale")
    public void invokeScale(T entity, MatrixStack matrices, float amount);

    @Invoker("isVisible")
    public boolean invokeIsVisible(T entity);

    @Invoker("getRenderLayer")
    public RenderLayer invokeGetRenderLayer(T entity, boolean showBody, boolean translucent, boolean showOutline);

    @Invoker("getAnimationCounter")
    public float invokeGetAnimationCounter(T entity, float tickDelta);

    @Invoker("getHandSwingProgress")
    public float invokeGetHandSwingProgress(LivingEntity livingEntity, float g);

    @Invoker("getAnimationProgress")
    public float invokeGetAnimationProgress(LivingEntity livingEntity, float g);

    @Invoker("setupTransforms")
    public void invokeSetupTransforms(LivingEntity livingEntity, MatrixStack matrixStack,float l3,float h,float g);

}
