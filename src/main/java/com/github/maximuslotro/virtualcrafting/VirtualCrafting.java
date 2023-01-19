package com.github.maximuslotro.virtualcrafting;

import net.minecraft.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

}
