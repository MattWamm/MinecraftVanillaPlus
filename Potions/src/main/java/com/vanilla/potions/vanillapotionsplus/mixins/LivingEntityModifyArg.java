package com.vanilla.potions.vanillapotionsplus.mixins;

import com.vanilla.potions.vanillapotionsplus.effect.FabricEffects;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public class LivingEntityModifyArg {

    @ModifyArg(method = "updatePotionVisibility", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setInvisible(Z)V"), index = 0)
    public boolean setInvisibleInject(boolean invisible) {
        final LivingEntity self = ((LivingEntity) (Object) this);
        return invisible == true ? true : (self.hasStatusEffect(FabricEffects.PHASING));
    }
}
