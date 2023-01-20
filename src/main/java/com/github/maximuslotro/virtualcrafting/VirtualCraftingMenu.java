package com.github.maximuslotro.virtualcrafting;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

public class VirtualCraftingMenu extends WorkbenchContainer {

    private final IWorldPosCallable access;

    public VirtualCraftingMenu(int p_39356_, PlayerInventory p_39357_, IWorldPosCallable p_39358_) {
        super(p_39356_, p_39357_, p_39358_);
        this.access = p_39358_;
    }

    public VirtualCraftingMenu(int p_39353_, PlayerInventory p_39354_) {
        this(p_39353_, p_39354_, IWorldPosCallable.NULL);
    }

    // Override to return your menu type that identifies the screen to use
    @Override
    public ContainerType<?> getType() {
        return ContainerType.CRAFTING;
    }

    // Override to identify the block instance (used to force the user out of the screen if the block is destroyed)
    @Override
    public boolean stillValid(PlayerEntity p_39368_) {
        //return stillValid(this.access, p_39368_, MY_CRAFTING_BLOCK.get());
    	return true;
    }
}