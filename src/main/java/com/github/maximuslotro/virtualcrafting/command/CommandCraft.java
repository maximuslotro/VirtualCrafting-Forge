package com.github.maximuslotro.virtualcrafting.command;

import com.github.maximuslotro.virtualcrafting.VirtualCraftingMenu;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;

import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class CommandCraft extends BaseCommand 
{
	private static final ITextComponent CONTAINER_TITLE = new TranslationTextComponent("container.crafting");

    public CommandCraft(String name, int permissionLevel, boolean enabled) {
		super(name, permissionLevel, enabled);
	}

    @Override
	public LiteralArgumentBuilder<CommandSource> setExecution() {
		return builder
				.executes(CommandContext -> execute(CommandContext));
		
	}
    
	public int execute(CommandContext<CommandSource> context) {
    	if (context.getSource().getEntity() instanceof PlayerEntity) {
    		ServerPlayerEntity player = (ServerPlayerEntity)context.getSource().getEntity();

    		player.sendMessage(new StringTextComponent("Opening Crafting table"), player.getUUID());

    		//player.openMenu(craftingTableBlock.getMenuProvider(craftingTableBlock.defaultBlockState(), player.getCommandSenderWorld(), player.blockPosition()));
    		player.openMenu(getMenuProvider(player.level,player.blockPosition()));
            return Command.SINGLE_SUCCESS;
    	}
    	else {
    		context.getSource().sendFailure(new StringTextComponent("Must be a player!"));
    	}
    	return Command.SINGLE_SUCCESS;
    }

	public INamedContainerProvider getMenuProvider(World p_52241_, BlockPos p_52242_) {
	      return new SimpleNamedContainerProvider((p_52229_, p_52230_, p_52231_) -> {
	         return new VirtualCraftingMenu(p_52229_, p_52230_);
	      }, CONTAINER_TITLE);
	   }
}