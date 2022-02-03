package com.vanilla.potions.vanillapotionsplus;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import net.minecraft.util.Identifier;

public interface ExtraFlagComponent extends AutoSyncedComponent, ServerTickingComponent {

    ComponentKey<ExtraFlagComponent> KEY = ComponentRegistry.getOrCreate(
            new Identifier("vanillapotionsplus", "flagcomponent"), ExtraFlagComponent.class);



    void setPhazing(boolean value);
    boolean isPhazing();



}
