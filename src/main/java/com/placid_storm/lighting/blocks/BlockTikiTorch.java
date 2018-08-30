package com.placid_storm.lighting.blocks;

import com.placid_storm.lighting.tileentity.TileEntityTikiTorch;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockTikiTorch extends BlockBase implements ITileEntityProvider {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    protected static final AxisAlignedBB TIKI_TORCH_AABB = new AxisAlignedBB(0.1,0.0,0.1,0.9,1.8,0.9);

    public BlockTikiTorch(String name, Material material) {
        super(name, material);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setCreativeTab(CreativeTabs.DECORATIONS);
        this.hasTileEntity = true;
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
    public boolean isFullBlock(IBlockState state) {return false;}

    @Override
    public boolean isFullCube(IBlockState state) {return false;}

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {return TIKI_TORCH_AABB;}

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {return BlockRenderLayer.CUTOUT;}

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTikiTorch();
    }
}
