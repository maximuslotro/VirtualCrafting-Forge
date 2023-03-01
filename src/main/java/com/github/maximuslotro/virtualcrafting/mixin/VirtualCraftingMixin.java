package com.github.maximuslotro.virtualcrafting.mixin;
/*

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

@Mixin(ItemEntity.class)
public class VirtualCraftingMixin {
	@Inject(at = @At("HEAD"), method = "Lnet/minecraft/entity/item/ItemEntity;hurt(Lnet/minecraft/util/DamageSource;F)Z", cancellable = true)
	private void hurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> callback) {
		if(source.isFire()) {
			callback.setReturnValue(false);
		}
	}

	@Shadow
	public ItemStack getItem() {
	  throw new IllegalStateException("Mixin failed to shadow getItem()");
	}

}*/