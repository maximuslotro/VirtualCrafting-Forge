package com.github.maximuslotro.virtualcrafting.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.github.maximuslotro.virtualcrafting.VirtualCrafting;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.IWorldPosCallable;

@Mixin(Container.class)
public class VirtualCraftingMixin {
	/*
	@Inject(at = @At("HEAD"), method = "Lnet/minecraft/inventory/container/WorkbenchContainer;stillValid(Lnet/minecraft/util/IWorldPosCallable;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/block/Block;)Z", cancellable = true),remap=false)
	 public boolean stillValid(IWorldPosCallable p_216963_0_, PlayerEntity p_216963_1_, Block p_216963_2_, CallbackInfoReturnable<Boolean> callback) {
		if (VirtualCrafting.instance.ContainsCraftingPlayer(p_216963_1_)) {
			callback.setReturnValue(true);
		}
		return false;
	   }
	 */
	@Overwrite
	protected static boolean stillValid(IWorldPosCallable p_216963_0_, PlayerEntity p_216963_1_, Block p_216963_2_) {
		VirtualCrafting.getLogger().info("THE WORLD IS ENDING@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		if (VirtualCrafting.instance.ContainsCraftingPlayer(p_216963_1_)) {
			return true;
		}
	      return p_216963_0_.evaluate((p_216960_2_, p_216960_3_) -> {
	         return !p_216960_2_.getBlockState(p_216960_3_).is(p_216963_2_) ? false : p_216963_1_.distanceToSqr((double)p_216960_3_.getX() + 0.5D, (double)p_216960_3_.getY() + 0.5D, (double)p_216960_3_.getZ() + 0.5D) <= 64.0D;
	      }, true);
	   }
}