package net.tardis.client.renders.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderItemStackModel extends TileEntityItemStackRenderer {

    private ModelBase modelBase;
    private Minecraft mc;
    private ResourceLocation texture = null;

    public RenderItemStackModel(ModelBase model) {
        this.modelBase = model;
        mc = Minecraft.getMinecraft();
    }

    public RenderItemStackModel(ModelBase model, ResourceLocation texture) {
        this.modelBase = model;
        mc = Minecraft.getMinecraft();
        this.texture = texture;
    }

    @Override
    public void renderByItem(ItemStack itemStackIn) {
        GlStateManager.pushMatrix();
        if (texture != null) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        }
        modelBase.render(null, 0, 0, 0, 0, 0, 0);
        GlStateManager.popMatrix();
    }

}
