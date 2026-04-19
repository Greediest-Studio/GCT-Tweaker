package com.smd.gctweaker.integrations.crafttweaker;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import com.smd.gctweaker.integrations.gamestage.GameStageHelperNoEvent;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("gamestages")
@ZenExpansion("crafttweaker.player.IPlayer")
public class PlayerStageExpansionNoEvent{

    @ZenMethod
    public static boolean hasGameStageSilent(IPlayer player, String stage) {
        EntityPlayer actualPlayer = CraftTweakerMC.getPlayer(player);
        return GameStageHelperNoEvent.hasStageSilent(actualPlayer, stage);
    }

    @ZenMethod
    public static boolean hasAnyGameStagesSilent(IPlayer player, String... stages) {
        EntityPlayer actualPlayer = CraftTweakerMC.getPlayer(player);
        return GameStageHelperNoEvent.hasAnyStageSilent(actualPlayer, stages);
    }

    @ZenMethod
    public static boolean hasAllGameStagesSilent(IPlayer player, String... stages) {
        EntityPlayer actualPlayer = CraftTweakerMC.getPlayer(player);
        return GameStageHelperNoEvent.hasAllStagesSilent(actualPlayer, stages);
    }
}
