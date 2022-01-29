package com.vanilla.potions.vanillapotionsplus.mixins;


import com.vanilla.potions.vanillapotionsplus.FabricEffects;
import com.vanilla.potions.vanillapotionsplus.FabricPotions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.WitchEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(WitchEntity.class)
public abstract class WitchEntityMixin{

    @Shadow
    public abstract boolean isDrinking();

    /**
     * @author MattWamm
     * @Reason Because any other way of overwriting the potions the witch throws Leaves the existing potions
     */
    @Overwrite
    public void attack(LivingEntity target, float pullProgress) {
        final WitchEntity self = ((WitchEntity) (Object) this);


        if (this.isDrinking()) {
            return;
        }
        Vec3d vec3d = target.getVelocity();
        double d = target.getX() + vec3d.x - self.getX();
        double yMinusValue = 1.1f; //if you are small it needs to aim lower... normally it shoots over you.
        if(target.hasStatusEffect(FabricEffects.SHRINKING)) {
            yMinusValue += 2;
        }
        double e = target.getEyeY() - yMinusValue - self.getY();
        double f = target.getZ() + vec3d.z - self.getZ();
        double g = Math.sqrt(d * d + f * f);
        Potion potion = Potions.HARMING;
        if (target instanceof RaiderEntity) {
            potion = target.getHealth() <= 4.0f ? Potions.HEALING : Potions.REGENERATION;
            if(target.getHealth() >= 4.0f && !target.hasStatusEffect(FabricEffects.GROWING))
            {
                potion = FabricPotions.GROWING;
            }
            self.setTarget(null);
        } else if (g >= 8.0 && !target.hasStatusEffect(StatusEffects.SLOWNESS)) {
            potion = Potions.SLOWNESS;
        } else if (target.getHealth() >= 8.0f && !target.hasStatusEffect(StatusEffects.POISON)) {
            potion = Potions.POISON;
        } else if (g <= 3.0 && !target.hasStatusEffect(StatusEffects.WEAKNESS) && self.getRandom().nextFloat() < 0.25f) {
            potion = Potions.WEAKNESS;
        } else if(!target.hasStatusEffect(FabricEffects.SHRINKING) && potion == Potions.HARMING)
        {
            potion = FabricPotions.SHRINKING;
        }

        PotionEntity potionEntity = new PotionEntity(self.world, self);
        potionEntity.setItem(PotionUtil.setPotion(new ItemStack(Items.SPLASH_POTION), potion));
        potionEntity.setPitch(potionEntity.getPitch() - -20.0f);
        potionEntity.setVelocity(d, e + g * 0.2, f, 0.75f, 8.0f);
        if (!self.isSilent()) {
            self.world.playSound(null, self.getX(), self.getY(), self.getZ(), SoundEvents.ENTITY_WITCH_THROW, self.getSoundCategory(), 1.0f, self.getRandom().nextFloat() * 0.8f);
        }

        self.world.spawnEntity(potionEntity);
    }



}
