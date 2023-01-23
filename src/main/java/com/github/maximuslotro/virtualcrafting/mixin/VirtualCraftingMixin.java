package com.github.maximuslotro.virtualcrafting.mixin;

import net.minecraft.server.Main;

import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Main.class)
public class VirtualCraftingMixin {
	@Shadow
    private static Logger LOGGER;
	
	@Inject(at = @At("HEAD"), method = "loadLevel()V", remap = false)
	private void loadLevel(CallbackInfo info) {
		LOGGER.info("This line is printed by an example mod mixin!");
	}
}