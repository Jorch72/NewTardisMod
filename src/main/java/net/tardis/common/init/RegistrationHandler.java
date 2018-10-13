package net.tardis.common.init;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.tardis.Tardis;
import net.tardis.network.proxy.CommonProxy;

@Mod.EventBusSubscriber(modid = Tardis.MODID)
public class RegistrationHandler {

    @SubscribeEvent //Register Blocks
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        TBlocks.init();
        for (Block block : TBlocks.BLOCK_LIST) {
            System.out.println(block.getRegistryName());
            event.getRegistry().register(block);
        }
        CommonProxy.regTiles();
    }

}
