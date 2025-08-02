package com.github.maximuslotro.virtualcrafting.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;

public class CommandCraft extends BaseCommand 
{
	private static final Component CONTAINER_TITLE = new TranslatableComponent("container.crafting");

    public CommandCraft(String name, int permissionLevel, boolean enabled) {
		super(name, permissionLevel, enabled);
	}

    @Override
	public LiteralArgumentBuilder<CommandSourceStack> setExecution() {
		return builder
				.executes(CommandContext -> execute(CommandContext));
		
	}
    
	public int execute(CommandContext<CommandSourceStack> context) {
    	if (context.getSource().getEntity() instanceof ServerPlayer) {
    		try {
    			ServerPlayer player = context.getSource().getPlayerOrException();
				player.openMenu(new SimpleMenuProvider((i, playerInventory, playerEntity) ->
				        new CraftingMenu(i, playerInventory, ContainerLevelAccess.create(player.getCommandSenderWorld(), player.blockPosition())) {
				            public boolean stillValid(ServerPlayer player) {
				                return true;
				            }
				        }, CONTAINER_TITLE));
			} catch (CommandSyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return Command.SINGLE_SUCCESS;
    	}
    	else {
    		context.getSource().sendSuccess(new TextComponent("Must be a player!"), false);
    	}
    	return Command.SINGLE_SUCCESS;
    }
}