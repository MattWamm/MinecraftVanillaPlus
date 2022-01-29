package com.vanilla.potions.vanillapotionsplus.mixins;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;

import java.lang.annotation.Annotation;

import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



@Mixin(BrewingRecipeRegistry.class)
public interface BrewingRegistryMixin{
    @Invoker("registerPotionRecipe")
    public static void invokeRegisterPotionRecipe(Potion input, Item item, Potion output)
    {
        throw new AssertionError();
    }
}
