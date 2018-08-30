package com.placid_storm.lighting.blocks;

import com.placid_storm.lighting.Main;
import com.placid_storm.lighting.init.ModBlocks;
import com.placid_storm.lighting.init.ModItems;
import com.placid_storm.lighting.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material) {

        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        //setCreativeTab(CustomTabs.MODBLOCKS);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {

        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
