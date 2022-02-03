package com.vanilla.potions.vanillapotionsplus;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;

public class ComponentImplementation implements ExtraFlagComponent {
    boolean phazing = false;

    public ComponentImplementation(Entity livingEntity) {

    }

    @Override
    public void serverTick() {

    }

    @Override public void readFromNbt(NbtCompound tag) { this.phazing = tag.getBoolean("phazing"); }
    @Override public void writeToNbt(NbtCompound tag) { tag.putBoolean("phazing", this.phazing); }

    @Override
    public void setPhazing(boolean value) {
        this.phazing = value;
    }

    @Override
    public boolean isPhazing() {
        return this.phazing;
    }
}
