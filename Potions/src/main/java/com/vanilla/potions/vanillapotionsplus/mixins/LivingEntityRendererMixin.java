package com.vanilla.potions.vanillapotionsplus.mixins;


import com.vanilla.potions.vanillapotionsplus.effect.FabricEffects;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin extends EntityRenderer<LivingEntity> {


    protected LivingEntityRendererMixin(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

//    @Inject(method = "isVisible", at = @At("RETURN"),cancellable = true)
//    private void isVisibleInjection(LivingEntity livingEntity ,CallbackInfoReturnable<Boolean> cir)
//    {
//        cir.setReturnValue(livingEntity.hasStatusEffect(FabricEffects.PHASING) ? false : cir.getReturnValue());
//    }


    @ModifyVariable(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/VertexConsumerProvider;getBuffer(Lnet/minecraft/client/render/RenderLayer;)Lnet/minecraft/client/render/VertexConsumer;", shift = At.Shift.BEFORE))
    private RenderLayer changeRenderLayerWhenTranslucent(RenderLayer original, LivingEntity entity) {
        if(entity != null) {
            if(entity.hasStatusEffect(FabricEffects.PHASING)) {
                return RenderLayer.getItemEntityTranslucentCull(getTexture(entity));
            }
        }
        return original;
    }


    @ModifyArgs(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"))
    private void renderColorChangedModel(Args args,  LivingEntity livingEntity, float f, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        Entity self = ((Entity)(Object)this);
        self.world.getEntitiesByClass(LivingEntity.class,new Box(self.getPos(),new Vec3d(100, 100, 100)),null);
        if(livingEntity.hasStatusEffect(FabricEffects.PHASING))
            args.set(7, 0.9f);

        if(livingEntity.hasStatusEffect(StatusEffects.INVISIBILITY))
            args.set(7, 0f);


    }




}
