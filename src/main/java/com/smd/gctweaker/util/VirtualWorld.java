package com.smd.gctweaker.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class VirtualWorld extends WorldClient {

    private static final WorldSettings SETTINGS = new WorldSettings(0, GameType.CREATIVE, false, false, WorldType.FLAT);
    private final Map<BlockPos, IBlockState> blockMap = new HashMap<>();
    private final Map<BlockPos, TileEntity> tileMap = new HashMap<>();

    public VirtualWorld() {
        super(null, SETTINGS, 0, EnumDifficulty.PEACEFUL, Minecraft.getMinecraft().profiler);
    }

    public void setVirtualBlock(BlockPos pos, IBlockState state) {
        blockMap.put(pos, state);
    }

    public void setVirtualTileEntity(BlockPos pos, TileEntity tileEntity) {
        tileMap.put(pos, tileEntity);
        tileEntity.setWorld(this);
        tileEntity.validate();
    }

    @Override
    public IBlockState getBlockState(BlockPos pos) {
        return blockMap.getOrDefault(pos, Blocks.AIR.getDefaultState());
    }

    @Override
    public TileEntity getTileEntity(BlockPos pos) {
        return tileMap.get(pos);
    }

    @Override
    public boolean isAirBlock(BlockPos pos) {
        IBlockState state = getBlockState(pos);
        return state.getBlock().isAir(state, this, pos);
    }

    @Override
    public Biome getBiome(BlockPos pos) {
        return Biomes.PLAINS;
    }

    @Override
    public int getLightFromNeighborsFor(EnumSkyBlock type, BlockPos pos) {
        return 15;
    }

    @Override
    public float getLightBrightness(BlockPos pos) {
        return 1.0f;
    }

    @Override
    protected IChunkProvider createChunkProvider() {
        return null;
    }
}

