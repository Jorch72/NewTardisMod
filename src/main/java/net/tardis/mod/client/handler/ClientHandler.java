package net.tardis.mod.client.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.tardis.mod.Tardis;
import net.tardis.mod.common.blocks.INoBox;
import net.tardis.mod.common.entities.vehicles.EntityBessie;
import net.tardis.mod.network.NetworkHandler;
import net.tardis.mod.network.packets.MessageUpdateBessie;

@Mod.EventBusSubscriber(modid = Tardis.MODID, value = Side.CLIENT)
public class ClientHandler {

    @SubscribeEvent
    public static void honkMyHorn(TickEvent.ClientTickEvent e) {
        if (Minecraft.getMinecraft().player == null) return;
        if (Minecraft.getMinecraft().player.getRidingEntity() instanceof EntityBessie) {
            EntityBessie bessie = (EntityBessie) Minecraft.getMinecraft().player.getRidingEntity();
            Entity driver = bessie.getControllingPassenger();
            if (driver.getEntityId() == Minecraft.getMinecraft().player.getEntityId()) {
                if (Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed()) {
                    NetworkHandler.NETWORK.sendToServer(new MessageUpdateBessie(bessie.getEntityId()));
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void cancelBB(DrawBlockHighlightEvent event) {
    	if(event.getTarget() != null && event.getTarget().getBlockPos() != null && !BlockPos.ORIGIN.equals(event.getTarget().getBlockPos()) && event.getPlayer().world.getBlockState(event.getTarget().getBlockPos()).getBlock() instanceof INoBox) {
    		event.setCanceled(true);
    	}
    }

}
