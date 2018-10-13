package net.tardis.network.proxy;

import net.tardis.common.tileentity.TileEntityTardis;
import net.tardis.util.RegUtils;

public class CommonProxy implements IProxy {

    public static void regTiles() {
        RegUtils.regTile(TileEntityTardis.class);
    }

    @Override
    public void preInit() {

    }

    @Override
    public void init() {

    }

    @Override
    public void postInit() {

    }
}
