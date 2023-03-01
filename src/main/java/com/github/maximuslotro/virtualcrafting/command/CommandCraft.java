package com.github.maximuslotro.virtualcrafting.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class CommandCraft extends BaseCommand 
{
	private static final ITextComponent CONTAINER_TITLE = new StringTextComponent("Crafting Gui");

    public CommandCraft(String name, int permissionLevel, boolean enabled) {
		super(name, permissionLevel, enabled);
	}

    @Override
	public LiteralArgumentBuilder<CommandSource> setExecution() {
		return builder
				.executes(CommandContext -> execute(CommandContext));
		
	}
    
	public int execute(CommandContext<CommandSource> context) {
    	if (context.getSource().getEntity() instanceof ServerPlayerEntity) {
    		ServerPlayerEntity player = (ServerPlayerEntity)context.getSource().getEntity();
			player.sendMessage(new StringTextComponent("Opening Crafting table"), player.getUUID());
			player.openMenu(new SimpleNamedContainerProvider((i, playerInventory, playerEntity) ->
			        new WorkbenchContainer(i, playerInventory, IWorldPosCallable.create(player.getCommandSenderWorld(), player.blockPosition())) {
			            @Override
			        	public boolean stillValid(PlayerEntity player) {
			                return true;
			            }
			        }, CONTAINER_TITLE));
    		player.sendMessage(new StringTextComponent("Crafting opened"), player.getUUID());
            return Command.SINGLE_SUCCESS;
    	}
    	else {
    		context.getSource().sendFailure(new StringTextComponent("Must be a player!"));
    	}
    	return Command.SINGLE_SUCCESS;
    }

}