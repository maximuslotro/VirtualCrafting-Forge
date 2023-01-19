package com.github.maximuslotro.virtualcrafting;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class CommandCraft  extends BaseCommand 
{

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

    		context.getSource().sendSuccess(new StringTextComponent("Opening Crafting table"), false);

    		CraftingTableBlock craftingTableBlock = new CraftingTableBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD));
    		player.openMenu(craftingTableBlock.getMenuProvider(craftingTableBlock.defaultBlockState(), player.getCommandSenderWorld(), player.blockPosition()));
            return Command.SINGLE_SUCCESS;
    	}
    	else {
    		context.getSource().sendFailure(new StringTextComponent("Must be a player!"));
    	}
    	return Command.SINGLE_SUCCESS;
    }
}