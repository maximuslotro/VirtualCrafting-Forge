package com.github.maximuslotro.virtualcrafting;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.FMLNetworkConstants;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(VirtualCrafting.MODID)
public class VirtualCrafting 
{
    public static final String MODID = "virtualcrafting";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public VirtualCrafting() {
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(this::registerCommands);
    }

    @SubscribeEvent
    public void registerCommands(final RegisterCommandsEvent event)
    {
    	LOGGER.info("Registering Craft Command");
    	CommandCraft.register(event.getDispatcher());
    }

}
