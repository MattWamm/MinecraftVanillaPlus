package com.vanilla.potions.vanillapotionsplus;

import com.vanilla.potions.vanillapotionsplus.effect.FabricEffects;
import com.vanilla.potions.vanillapotionsplus.potion.FabricPotions;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.Entity;

public class vanillapotionsplus implements ModInitializer, EntityComponentInitializer {


    @Override
    public void onInitialize() {
        new FabricEffects();
        new FabricPotions();
    }



    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
            registry.beginRegistration(Entity.class, ExtraFlagComponent.KEY)
                    .impl(ComponentImplementation.class)
                    .respawnStrategy(RespawnCopyStrategy.NEVER_COPY)
                    .end(ComponentImplementation::new);

    }
}
