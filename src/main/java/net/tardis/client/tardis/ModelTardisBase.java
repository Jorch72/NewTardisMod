package net.tardis.client.tardis;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public abstract class ModelTardisBase extends ModelBase {

    //Render all tardis pieces
    public void renderAll(TardisState state, float scale) {


        //Left Door
        GlStateManager.popMatrix();
        if (state.equals(TardisState.OPEN)) {

        } else {

        }
        renderDoorLeft(scale);
        GlStateManager.popMatrix();

        //Right Door
        GlStateManager.pushMatrix();
        renderDoorRight(scale);
        GlStateManager.popMatrix();

        //Bigger on the inside and Shell
        GlStateManager.pushMatrix();
        renderShell(scale);
        renderBoti(scale);
        GlStateManager.popMatrix();
    }

    private void renderBoti(float scale) {
        //TODO - BOTI stuff here
    }


    public abstract void renderDoorLeft(float scale);

    public abstract void renderDoorRight(float scale);

    public abstract void renderShell(float scale);

    public abstract ResourceLocation getTexture();

    public void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public enum TardisState {
        OPEN, CLOSED, OPENING, CLOSING
    }

}
