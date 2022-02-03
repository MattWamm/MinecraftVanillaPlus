package com.vanilla.potions.vanillapotionsplus.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityAccessor extends Entity {


    public LivingEntityAccessor(EntityType<?> type, World world) {
        super(type, world);
    }

//    @Inject(method = "onStatusEffectApplied", at = @At("TAIL"))
//    private void updateStatusEffectWhenApplied(StatusEffectInstance effectInstance, Entity source, CallbackInfo ci) {
//        SyncStatusEffectsUtil.sendStatusEffectUpdatePacket((LivingEntity)(Object)this, SyncStatusEffectsUtil.UpdateType.APPLY, effectInstance);
//    }
}
