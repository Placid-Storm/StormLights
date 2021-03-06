package com.placid_storm.lighting.init;

import com.placid_storm.lighting.blocks.BlockCandelabra;
import com.placid_storm.lighting.blocks.BlockFenceTopper;
import com.placid_storm.lighting.blocks.BlockFenceTopperTop;
import com.placid_storm.lighting.blocks.BlockTikiTorch;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block TIKITORCH = new BlockTikiTorch("tikitorch", Material.WOOD);
    public static final Block FENCETOPPER = new BlockFenceTopper("fencetopper", Material.IRON);
    public static final Block FENCETOPPERTOP = new BlockFenceTopperTop("fencetoppertop", Material.IRON);
    public static final Block CANDELABRA = new BlockCandelabra("candelabra", Material.IRON);

    //public static final Block RUBY_ORE = new RubyOre("ruby_ore", Material.ROCK);
}
