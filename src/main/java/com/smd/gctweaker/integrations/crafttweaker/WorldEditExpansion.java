package com.smd.gctweaker.integrations.crafttweaker;

import com.smd.gctweaker.util.ToolUtils;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.block.IBlock;
import crafttweaker.api.world.IWorld;
import net.minecraft.util.math.BlockPos;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.List;

@ZenRegister
@ZenExpansion("crafttweaker.world.IWorld")
public class WorldEditExpansion {

    @ZenMethod
    public static List<IBlock> getBlocksBy2Pos(IWorld iWorld, BlockPos pos1, BlockPos pos2) {
        return collectBlocksInBox(iWorld, pos1.getX(), pos1.getY(), pos1.getZ(), pos2.getX(), pos2.getY(), pos2.getZ());
    }

    @ZenMethod
    public static List<IBlock> getBlocksByCenterAndRadius(IWorld iWorld, BlockPos center, int radius) {
        return collectBlocksInCenterRadius(iWorld, center.getX(), center.getY(), center.getZ(), radius);
    }

    @ZenMethod
    public static List<IBlock> collectBlocksInBox(IWorld iWorld, int x1, int y1, int z1, int x2, int y2, int z2) {
        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.max(Math.min(y1, y2), 0);
        int maxY = Math.min(Math.max(y1, y2), 255);
        int minZ = Math.min(z1, z2);
        int maxZ = Math.max(z1, z2);

        List<IBlock> blocks = new ArrayList<>();

        for (int y = minY; y <= maxY; y++) {
            for (int z = minZ; z <= maxZ; z++) {
                for (int x = minX; x <= maxX; x++) {
                    IBlock block = iWorld.getBlock(x, y, z);
                    if (ToolUtils.isValidBlock(block)) continue;
                    blocks.add(block);
                }
            }
        }
        return blocks;
    }

    @ZenMethod
    public static List<IBlock> collectBlocksInCenterRadius(IWorld iWorld, int centerX, int centerY, int centerZ, int radius) {
        if (radius < 0) throw new IllegalArgumentException("Radius cannot be negative");

        List<IBlock> blocks = new ArrayList<>();
        final long rSquared = (long) radius * radius;
        final int minY = Math.max(centerY - radius, 0);
        final int maxY = Math.min(centerY + radius, 255);

        for (int y = minY; y <= maxY; y++) {
            final int dy = y - centerY;
            final long dy2 = (long) dy * dy;
            if (dy2 > rSquared) continue;

            final long r2MinusDy2 = rSquared - dy2;

            final int maxDz = (int) Math.sqrt(r2MinusDy2);

            for (int dz = -maxDz; dz <= maxDz; dz++) {
                final long dz2 = (long) dz * dz;
                if (dz2 > r2MinusDy2) continue;

                final long r2MinusDy2Dz2 = r2MinusDy2 - dz2;
                final int z = centerZ + dz;

                final int maxDx = (int) Math.sqrt(r2MinusDy2Dz2);
                final int startX = centerX - maxDx;
                final int endX = centerX + maxDx;

                for (int x = startX; x <= endX; x++) {
                    IBlock block = iWorld.getBlock(x, y, z);
                    if (ToolUtils.isValidBlock(block)) continue;
                    blocks.add(block);
                }
            }
        }
        return blocks;
    }
}