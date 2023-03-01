package com.github.maximuslotro.virtualcrafting;

import net.minecraft.command.CommandSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.network.FMLNetworkConstants;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.maximuslotro.virtualcrafting.command.CommandCraft;
import com.mojang.brigadier.CommandDispatcher;

@Mod(VirtualCrafting.MODID)
@Mod.EventBusSubscriber(modid = VirtualCrafting.MODID, bus = Bus.MOD,value = Dist.DEDICATED_SERVER)
public class VirtualCrafting 
{
    public static final String MODID = "virtualcrafting";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public VirtualCrafting() {
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerCommands(final RegisterCommandsEvent event)
    {
    	LOGGER.info("Registering Craft Command");
    	CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
    	dispatcher.register(new CommandCraft("craft", 0, true).getBuilder());
    }

}
