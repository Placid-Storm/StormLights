package com.placid_storm.lighting.blocks;

import com.placid_storm.lighting.init.ModBlocks;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
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

public class BlockFenceTopper extends BlockBase {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    protected static final AxisAlignedBB FENCE_TOPPER_AABB = new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.0, 0.625);

    public BlockFenceTopper(String name, Material material) {
        super(name, material);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setCreativeTab(CreativeTabs.DECORATIONS);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        EnumFacing enumfacing = placer.getHorizontalFacing().rotateY();
        return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, 0, placer).withProperty(FACING, enumfacing);
    }
    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3));
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        if (pos.getY() >= worldIn.getHeight()-1){
            return false;

        }
        else {
            IBlockState state = worldIn.getBlockState(pos.down());
            return (super.canPlaceBlockAt(worldIn, pos) && super.canPlaceBlockAt(worldIn, pos.up()));
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos topPos = new BlockPos(x, y+1, z);

        if (worldIn.getBlockState(topPos) == Blocks.AIR.getDefaultState()){
            worldIn.setBlockState(topPos, ModBlocks.FENCETOPPERTOP.getDefaultState(), 3);}
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos topPos = new BlockPos(x, y+1, z);

        if (worldIn.getBlockState(topPos) == ModBlocks.FENCETOPPERTOP.getDefaultState()){
            worldIn.setBlockToAir(topPos);
        }
    }

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
        BlockPos torchPos = new BlockPos(x, y+2, z);

        if (itemstack.isEmpty()) {
            return true;
        }
        else{
            Item block = itemstack.getItem();

            if (block == Item.getItemFromBlock(Blocks.TORCH) && worldIn.getBlockState(torchPos) == Blocks.AIR.getDefaultState()){
                itemstack.shrink(1);
                worldIn.setBlockState(torchPos,Blocks.TORCH.getDefaultState(), 3);
            }
            else if (block == Item.getItemFromBlock(ModBlocks.CANDELABRA) && worldIn.getBlockState(torchPos) == Blocks.AIR.getDefaultState()){
                itemstack.shrink(1);
                worldIn.setBlockState(torchPos,ModBlocks.CANDELABRA.getDefaultState().withProperty(FACING,facing), 3);
            }
        }
        return false;
    }
}
