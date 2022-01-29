package com.vanilla.potions.vanillapotionsplus;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
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
