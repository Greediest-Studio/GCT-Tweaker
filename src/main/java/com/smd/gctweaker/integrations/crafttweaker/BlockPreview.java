package com.smd.gctweaker.integrations.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.world.IBlockPos;
import stanhebben.zenscript.annotations.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.smd.gctweaker.handler.RenderEventHandler.controller;

@ZenRegister
@ZenClass("mods.gctweaker.BlockPreview")
@SideOnly(Side.CLIENT)
public class BlockPreview {

    @ZenMethod
    public static void renderBlockxyz(IBlockState state, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        controller.startRender(state, pos, 1000, 0xF000F0);
    }

    @ZenMethod
    public static void renderBlockxyzTimed(IBlockState state, int x, int y, int z, int durationMillis) {
        BlockPos pos = new BlockPos(x, y, z);
        controller.startRender(state, pos, durationMillis, 0xF000F0);
    }

    @ZenMethod
    public static void renderBlockxyzWithLight(IBlockState state, int x, int y, int z, int durationMillis, int lightLevel) {
        BlockPos pos = new BlockPos(x, y, z);
        controller.startRender(state, pos, durationMillis, lightLevel);
    }

    @ZenMethod
    public static void renderBlockpos(IBlockState state, IBlockPos pos) {
        BlockPos realPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        controller.startRender(state, realPos, 1000, 0xF000F0);
    }

    @ZenMethod
    public static void renderBlockposTimed(IBlockState state, IBlockPos pos, int durationMillis) {
        BlockPos realPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        controller.startRender(state, realPos, durationMillis, 0xF000F0);
    }

    @ZenMethod
    public static void renderBlockposWithLight(IBlockState state, IBlockPos pos, int durationMillis, int lightLevel) {
        BlockPos realPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        controller.startRender(state, realPos, durationMillis, lightLevel);
    }

    @ZenMethod
    public static void stopRender() {
        controller.stopRender();
    }
}