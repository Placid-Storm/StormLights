package com.placid_storm.lighting.blocks;


import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFenceTopperTop extends BlockBase {
    public BlockFenceTopperTop(String name, Material material) {
        super(name, material);
    }

    protected static final AxisAlignedBB FENCE_TOPPER_AABB = new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.0, 0.625);

    @Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {return false;}

    @Override
    public boolean isFullCube(IBlockState state) {return false;}

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {return FENCE_TOPPER_AABB;}
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = playerIn.getHeldItem(EnumHand.MAIN_HAND);
        EnumFacing TOP = EnumFacing.UP;

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();


        if (itemstack.isEmpty()) {
            return true;
        }
        else{
            Item block = itemstack.getItem();

            if (block == Item.getItemFromBlock(Blocks.TORCH) && canPlaceTorchOnTop(state, worldIn, pos)){
                itemstack.shrink(1);
                worldIn.setBlockState(new BlockPos(x, y + 1, z),Blocks.TORCH.getDefaultState(), 3);

            }
        }
        return false;
    }
}
