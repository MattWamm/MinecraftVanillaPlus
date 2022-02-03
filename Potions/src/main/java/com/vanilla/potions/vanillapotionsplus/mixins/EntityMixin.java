package com.vanilla.potions.vanillapotionsplus.mixins;

import com.vanilla.potions.vanillapotionsplus.ExtraFlagComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin<T> {

    @Inject(method = "isInvisible", at = @At("RETURN"), cancellable = true)
    private void isInvisibleInjection(CallbackInfoReturnable<Boolean> cir)
    {
        Entity self = (Entity)(Object)this;
        if(ExtraFlagComponent.KEY.get(self).isPhazing())
        {
            cir.setReturnValue(true);
        }
    }


    @Shadow public abstract World getWorld();

    @Inject(method = "isInvisibleTo", at = @At("RETURN"), cancellable = true)
    private void isInvisibleToInjection(PlayerEntity player, CallbackInfoReturnable<Boolean> cir)
    {
        Entity self = (Entity)(Object)this;
        if(ExtraFlagComponent.KEY.get(self).isPhazing())
        {
            cir.setReturnValue(false);
        }
    }



}
