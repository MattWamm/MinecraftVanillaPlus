package com.vanilla.potions.vanillapotionsplus.mixins;

import net.minecraft.entity.data.DataTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DataTracker.class)
public interface DataTrackerMixin {

    @Accessor("dirty")
    public void setDirty(boolean dirty);

}
