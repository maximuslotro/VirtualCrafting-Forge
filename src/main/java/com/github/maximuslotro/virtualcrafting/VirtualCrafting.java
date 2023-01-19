package com.github.maximuslotro.virtualcrafting;

import net.minecraft.command.CommandSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.CommandDispatcher;

@Mod(VirtualCrafting.MODID)
@Mod.EventBusSubscriber(modid = VirtualCrafting.MODID, bus = Bus.MOD,value = Dist.DEDICATED_SERVER)
public class VirtualCrafting 
{
    public static final String MODID = "virtualcrafting";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public VirtualCrafting() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerCommands(final RegisterCommandsEvent event)
    {
    	LOGGER.info("Registering Craft Command");
    	CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
		
    	CommandCraft command = new CommandCraft("craft", 0, true);
    	if (command.isEnabled() && command.setExecution() != null) {
			dispatcher.register(command.getBuilder());
		}
    }

}
