package com.vanilla.potions.vanillapotionsplus.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;


import org.jetbrains.annotations.Nullable;

public class FabricPotion extends Potion {

    private FabricPotion extended = null;
    private FabricPotion empowered = null;

    public FabricPotion(@Nullable String baseName, StatusEffectInstance... effects)
    {
        super(baseName,effects);
    }
    public FabricPotion(StatusEffectInstance... effects) {
        this((String)null, effects);
    }


}
