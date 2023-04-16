package com.github.maximuslotro.virtualcrafting;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class CommandCraft
{
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("craft").executes(CommandContext -> execute(CommandContext)));
	}

	public static int execute(CommandContext<CommandSource> context) {
    	if (context.getSource().getEntity() instanceof ServerPlayerEntity) {
    		ServerPlayerEntity player = (ServerPlayerEntity) context.getSource().getEntity();
    		player.openMenu(new SimpleNamedContainerProvider((i, playerInventory, playerEntity) ->
                    new WorkbenchContainer(i, playerInventory, IWorldPosCallable.create(player.getCommandSenderWorld(), player.blockPosition())) {
                        public boolean stillValid(PlayerEntity p_75145_1_) {
                            return true;
                         }
                    }, new TranslationTextComponent("container.crafting")));
            return Command.SINGLE_SUCCESS;
    	}
    	else {
    		context.getSource().sendFailure(new StringTextComponent("Must be a player!"));
    	}
    	return Command.SINGLE_SUCCESS;
    }

}