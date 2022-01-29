package com.vanilla.potions.vanillapotionsplus;

import com.google.common.collect.Maps;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.RemoveEntityStatusEffectS2CPacket;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import virtuoel.pehkui.api.*;
import virtuoel.pehkui.command.argument.ScaleOperationArgumentType;
import virtuoel.pehkui.mixin.PlayerEntityMixin;
import virtuoel.pehkui.util.CommandUtils;

import java.util.EventListener;
import java.util.Map;
import java.util.UUID;


public class FabricEffect extends StatusEffect {
    private final Map<EntityAttribute, EntityAttributeModifier> attributeModifiers = Maps.newHashMap();


    protected FabricEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {

    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        applyEffect(entity,amplifier);
        for (Map.Entry<EntityAttribute, EntityAttributeModifier> entry : this.attributeModifiers.entrySet()) {
            EntityAttributeInstance entityAttributeInstance = attributes.getCustomInstance(entry.getKey());
            if (entityAttributeInstance == null) continue;
            EntityAttributeModifier entityAttributeModifier = entry.getValue();
            entityAttributeInstance.removeModifier(entityAttributeModifier);
            entityAttributeInstance.addPersistentModifier(new EntityAttributeModifier(entityAttributeModifier.getId(), this.getTranslationKey() + " " + amplifier, this.adjustModifierAmount(amplifier, entityAttributeModifier), entityAttributeModifier.getOperation()));
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        for(final ScaleType type : ScaleRegistries.SCALE_TYPES.values())
        {
            final ScaleData data = type.getScaleData(entity);
            data.setTargetScale(1f);
        }
        for (Map.Entry<EntityAttribute, EntityAttributeModifier> entry : this.attributeModifiers.entrySet()) {
            EntityAttributeInstance entityAttributeInstance = attributes.getCustomInstance(entry.getKey());
            if (entityAttributeInstance == null) continue;
            entityAttributeInstance.removeModifier(entry.getValue());
        }
    }


    private void applyEffect(LivingEntity entity, int amplifier)
    {

        if(this == FabricEffects.SHRINKING)
        {
            if(entity.hasStatusEffect(FabricEffects.GROWING))
                    entity.removeStatusEffect(FabricEffects.GROWING);
            ScaleTypes.KNOCKBACK.getScaleData(entity).setTargetScale(0);if(amplifier == 1)
            {
                ScaleTypes.BASE.getScaleData(entity).setTargetScale(0.3f);
            }
            else
            {
                float useValue = amplifier != 0 ? 0.5f / amplifier : 0.5f;
                ScaleTypes.BASE.getScaleData(entity).setTargetScale(useValue);
            }
            ScaleTypes.MOTION.getScaleData(entity).setTargetScale(0.5f);
            ScaleTypes.DEFENSE.getScaleData(entity).setTargetScale(2);
        }
        if(this == FabricEffects.GROWING)
        {
            if(entity.hasStatusEffect(FabricEffects.SHRINKING))
                entity.removeStatusEffect(FabricEffects.SHRINKING);
            amplifier += 1;
            ScaleTypes.BASE.getScaleData(entity).setTargetScale((float)amplifier + (amplifier == 1 ? 0.5f : 0));
            ScaleTypes.KNOCKBACK.getScaleData(entity).setTargetScale(3);
            ScaleTypes.HEALTH.getScaleData(entity).setTargetScale(1 + amplifier);
            ScaleTypes.ATTACK_SPEED.getScaleData(entity).setTargetScale(0.5f / amplifier);
        }
    }






}
