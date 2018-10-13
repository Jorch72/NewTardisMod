package net.tardis.network.proxy;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.tardis.client.renders.tileentity.RenderTileTardisExterior;
import net.tardis.common.tileentity.TileEntityTardis;

public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        super.init();
        tileRenders();
    }

    public void tileRenders() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTardis.class, new RenderTileTardisExterior());
    }
}
