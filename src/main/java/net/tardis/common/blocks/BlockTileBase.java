package net.tardis.common.blocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class BlockTileBase extends BlockBase {

    private Supplier<TileEntity> tileEntitySupplier;

    public BlockTileBase(Supplier<TileEntity> tileEntitySupplier, Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
        this.tileEntitySupplier = tileEntitySupplier;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return tileEntitySupplier.get();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }
}
