package com.vanilla.potions.vanillapotionsplus;

import com.vanilla.potions.vanillapotionsplus.mixins.BrewingRegistryMixin;
import net.minecraft.command.argument.ArgumentTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.util.registry.Registry;

public class FabricPotions {


    public static final FabricPotion SHRINKING;
    public static final FabricPotion LONG_SHRINKING;
    public static final FabricPotion STRONG_SHRINKING;
    public static final FabricPotion LONG_STRONG_SHRINKING;
    public static final FabricPotion GROWING;
    public static final FabricPotion LONG_GROWING;
    public static final FabricPotion STRONG_GROWING;
    public static final FabricPotion GIANT_GROWING;
    public static final FabricPotion GLOWING;
    public static final FabricPotion LONG_GLOWING;


    public FabricPotions()
    {

    }

    private static FabricPotion register(String name, Potion potion) {
        return (FabricPotion) Registry.register(Registry.POTION, name, potion);
    }
    static{
        //shrinking
        SHRINKING = register("shrinking",new FabricPotion("shrinking",new StatusEffectInstance[]{new StatusEffectInstance(FabricEffects.SHRINKING,4800)}));
        LONG_SHRINKING = register("long_shrinking",new FabricPotion("shrinking",new StatusEffectInstance[]{new StatusEffectInstance(FabricEffects.SHRINKING,9600)}));
        STRONG_SHRINKING = register("strong_shrinking",new FabricPotion("shrinking",new StatusEffectInstance[]{new StatusEffectInstance(FabricEffects.SHRINKING,4800, 2)}));
        LONG_STRONG_SHRINKING = register("long_strong_shrinking",new FabricPotion("shrinking",new StatusEffectInstance[]{new StatusEffectInstance(FabricEffects.SHRINKING,7200, 1)}));
        BrewingRegistryMixin.invokeRegisterPotionRecipe(Potions.MUNDANE, Items.SMALL_DRIPLEAF,SHRINKING);
        BrewingRegistryMixin.invokeRegisterPotionRecipe(SHRINKING, Items.REDSTONE,LONG_SHRINKING);
        BrewingRegistryMixin.invokeRegisterPotionRecipe(SHRINKING, Items.GLOWSTONE_DUST,STRONG_SHRINKING);
        BrewingRegistryMixin.invokeRegisterPotionRecipe(LONG_SHRINKING, Items.GLOWSTONE_DUST,LONG_STRONG_SHRINKING);
        //growing
        GROWING = register("growing",new FabricPotion("growing",new StatusEffectInstance[]{new StatusEffectInstance(FabricEffects.GROWING,4800)}));
        LONG_GROWING = register("long_growing",new FabricPotion("growing",new StatusEffectInstance[]{new StatusEffectInstance(FabricEffects.GROWING,9600)}));
        STRONG_GROWING = register("strong_growing",new FabricPotion("growing",new StatusEffectInstance[]{new StatusEffectInstance(FabricEffects.GROWING,4800, 1)}));
        GIANT_GROWING = register("giant_growing",new FabricPotion("growing",new StatusEffectInstance[]{new StatusEffectInstance(FabricEffects.GROWING,4800, 2)}));
        BrewingRegistryMixin.invokeRegisterPotionRecipe(Potions.MUNDANE, Items.BIG_DRIPLEAF,GROWING);
        BrewingRegistryMixin.invokeRegisterPotionRecipe(SHRINKING, Items.REDSTONE,LONG_GROWING);
        BrewingRegistryMixin.invokeRegisterPotionRecipe(SHRINKING, Items.GLOWSTONE_DUST,STRONG_GROWING);
        BrewingRegistryMixin.invokeRegisterPotionRecipe(LONG_SHRINKING, Items.GLOWSTONE_DUST,GIANT_GROWING);
        //glowing
        GLOWING = register("glowing",new FabricPotion("glowing" ,new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.GLOWING, 3600)}));
        LONG_GLOWING = register("long_glowing",new FabricPotion("glowing" ,new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.GLOWING, 6000)}));
        BrewingRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.GLOW_BERRIES,GLOWING);
        BrewingRegistryMixin.invokeRegisterPotionRecipe(GLOWING, Items.REDSTONE,LONG_GLOWING);

    }
}
