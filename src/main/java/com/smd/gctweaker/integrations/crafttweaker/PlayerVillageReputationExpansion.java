package com.smd.gctweaker.integrations.crafttweaker;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.Village;
import net.minecraft.village.VillageCollection;
import net.minecraft.world.World;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenExpansion("crafttweaker.player.IPlayer")
public class PlayerVillageReputationExpansion {

    /**
     * 声望范围在-30和10之间
     * 获取玩家在最近村庄的声望
     */
    @ZenMethod
    public static int getNearestVillageReputation(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        World world = mcPlayer.world;
        BlockPos playerPos = mcPlayer.getPosition();
        VillageCollection collection = world.getVillageCollection();
        Village village = collection.getNearestVillage(playerPos, 32);
        return village != null ? village.getPlayerReputation(mcPlayer.getUniqueID()) : 0;
    }

    /**
     * 设置玩家在最近村庄的声望
     */
    @ZenMethod
    public static void setNearestVillageReputation(IPlayer player, int reputation) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        World world = mcPlayer.world;
        BlockPos playerPos = mcPlayer.getPosition();
        VillageCollection collection = world.getVillageCollection();
        Village village = collection.getNearestVillage(playerPos, 32);
        if (village != null) {
            village.modifyPlayerReputation(mcPlayer.getUniqueID(), reputation);
        }
    }

    /**
     * 判断玩家在最近村庄是否声望过低
     */
    @ZenMethod
    public static boolean isNearestVillageReputationTooLow(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        World world = mcPlayer.world;
        BlockPos playerPos = mcPlayer.getPosition();
        VillageCollection collection = world.getVillageCollection();
        Village village = collection.getNearestVillage(playerPos, 32);
        return village != null && village.isPlayerReputationTooLow(mcPlayer.getUniqueID());
    }
}
