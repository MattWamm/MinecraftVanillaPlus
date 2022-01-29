package com.vanilla.potions.vanillapotionsplus;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricEffects {



    public FabricEffects() {
    }

    private static FabricEffect register(String id, StatusEffect entry) {
        return (FabricEffect) Registry.register(Registry.STATUS_EFFECT,new Identifier("vanillapotionsplus",id), entry);
    }

    public static final StatusEffect SHRINKING = register("shrinking",(new FabricEffect(StatusEffectCategory.NEUTRAL, 3128991)));
    public static final StatusEffect GROWING = register("growing",(new FabricEffect(StatusEffectCategory.NEUTRAL, 1384477)));
    public static final StatusEffect PHASING = register("phasing",(new FabricEffect(StatusEffectCategory.NEUTRAL, 10741248)));
    public static final StatusEffect KNOCKING = register("knocking",(new FabricEffect(StatusEffectCategory.NEUTRAL, 10741248)));
    public static final StatusEffect DASHING = register("dashing",(new FabricEffect(StatusEffectCategory.NEUTRAL, 10741248)));
    public static final StatusEffect TRIPPING = register("tripping",(new FabricEffect(StatusEffectCategory.NEUTRAL, 10741248)));
    public static final StatusEffect STONE_SKIN = register("stone_skin",(new FabricEffect(StatusEffectCategory.NEUTRAL, 10741248)));
    public static final StatusEffect CLIMBING = register("climbing",(new FabricEffect(StatusEffectCategory.NEUTRAL, 10741248)));
    public static final StatusEffect PURITY = register("purity",(new FabricEffect(StatusEffectCategory.NEUTRAL, 10741248)));
    public static final StatusEffect EXPLODING = register("exploding",(new FabricEffect(StatusEffectCategory.NEUTRAL, 10741248)));
}
