package net.tardis.util;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.tardis.Tardis;

public class RegUtils {

    public static void regTile(Class<? extends TileEntity> tileEntityClass) {
        GameRegistry.registerTileEntity(tileEntityClass, new ResourceLocation(Tardis.MODID, tileEntityClass.getSimpleName().replace("TileEntity", "")));
    }

}
