package net.tardis.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTardis extends TileEntity {

    private boolean isOpen = false;

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        setOpen(compound.getBoolean("isOpen"));
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setBoolean("open", isOpen);
        return super.writeToNBT(compound);
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
