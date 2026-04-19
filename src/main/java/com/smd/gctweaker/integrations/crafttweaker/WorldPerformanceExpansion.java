package com.smd.gctweaker.integrations.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.world.IWorld;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenExpansion("crafttweaker.world.IWorld")
public class WorldPerformanceExpansion {

    @ZenMethod
    public static double getMSPT(IWorld world) {
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        long[] times = server.tickTimeArray;
        long total = 0;
        for (long time : times) {
            total += time;
        }
        return total / 1000000.0 / times.length;
    }

    @ZenMethod
    public static double getTPS(IWorld world) {
        double mspt = getMSPT(world);
        return Math.min(1000.0 / mspt, 20.0);
    }
}

