package com.placid_storm.lighting.blocks;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockTikiTorch extends BlockBase{

    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    protected static final AxisAlignedBB TIKI_TORCH_AABB = new AxisAlignedBB(0.1,0.0,0.1,0.9,1.8,0.9);

    public BlockTikiTorch(String name, Material material) {
        super(name, material);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setCreativeTab(CreativeTabs.DECORATIONS);
        setLightLevel(1.0F);
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
    public boolean isOpaqueCube(IBlockState state) {return false;}

    @Override
    public boolean isFullCube(IBlockState state) {return false;}

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {return TIKI_TORCH_AABB;}

    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {

        //South
        EnumFacing enumfacing = (EnumFacing)stateIn.getValue(FACING);
        double d0 = (double)pos.getX() + 0.40625D;
        double d1 = (double)pos.getY() + 2.0D;
        double d2 = (double)pos.getZ() + 0.796875D;
        double d3 = 0.22D;
        double d4 = 0.27D;

        worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);

        //North
        double e0 = (double)pos.getX() + 0.5325D;
        double e1 = (double)pos.getY() + 2.0D;
        double e2 = (double)pos.getZ() + 0.140625D;
        double e3 = 0.22D;
        double e4 = 0.27D;

        worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, e0, e1, e2, 0.0D, 0.0D, 0.0D);
        worldIn.spawnParticle(EnumParticleTypes.FLAME, e0, e1, e2, 0.0D, 0.0D, 0.0D);

        //East
        double f0 = (double)pos.getX() + 0.140625D;
        double f1 = (double)pos.getY() + 2.0D;
        double f2 = (double)pos.getZ() + 0.40625D;
        double f3 = 0.22D;
        double f4 = 0.27D;

        worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, f0, f1, f2, 0.0D, 0.0D, 0.0D);
        worldIn.spawnParticle(EnumParticleTypes.FLAME, f0, f1, f2, 0.0D, 0.0D, 0.0D);

        //West
        double g0 = (double)pos.getX() + 0.796875D;
        double g1 = (double)pos.getY() + 2.0D;
        double g2 = (double)pos.getZ() + 0.5325D;
        double g3 = 0.22D;
        double g4 = 0.27D;

        worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, g0, g1, g2, 0.0D, 0.0D, 0.0D);
        worldIn.spawnParticle(EnumParticleTypes.FLAME, g0, g1, g2, 0.0D, 0.0D, 0.0D);

    }
}
