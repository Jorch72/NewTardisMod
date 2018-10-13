package net.tardis.common.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.tardis.Tardis;
import net.tardis.common.blocks.BlockTardis;

import java.util.ArrayList;

@GameRegistry.ObjectHolder(Tardis.MODID)
public class TBlocks {

    public static ArrayList<Block> BLOCK_LIST = new ArrayList<>();

    //Blocks
    public static Block TARDIS = null;

    public static void init() {
        TARDIS = createBlock(new BlockTardis(), "tardis");
    }

    public static Block createBlock(Block block, String name) {
        block.setRegistryName(name);
        block.setTranslationKey(name);
        return block;
    }

}
