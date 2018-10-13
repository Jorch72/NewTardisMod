package net.tardis.client.renders.tileentity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.tardis.client.tardis.ModelTardisBase;
import net.tardis.client.tardis.ModelTardisFirst;
import net.tardis.common.tileentity.TileEntityTardis;

public class RenderTileTardisExterior extends TileEntitySpecialRenderer<TileEntityTardis> {

    private ModelTardisBase tardisExterior = new ModelTardisFirst();

    @Override
    public void render(TileEntityTardis te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        tardisExterior.renderAll(te.isOpen() ? ModelTardisBase.TardisState.OPEN : ModelTardisBase.TardisState.CLOSED, 0.0625f);
        GlStateManager.popMatrix();
    }
}
