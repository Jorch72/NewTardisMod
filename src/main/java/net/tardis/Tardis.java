package net.tardis;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.tardis.network.proxy.CommonProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tardis.MODID, name = Tardis.NAME, version = Tardis.VERSION)
public class Tardis {

    public static final String MODID = "tardis", NAME = "The Tardis mod", VERSION = "30";
    public static Logger LOGGER = LogManager.getLogger(NAME);

    @SidedProxy(clientSide = "net.tardis.network.proxy.ClientProxy", serverSide = "net.tardis.network.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }

}