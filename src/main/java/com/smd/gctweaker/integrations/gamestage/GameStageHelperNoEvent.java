package com.smd.gctweaker.integrations.gamestage;


import net.darkhax.gamestages.GameStageHelper;
import net.darkhax.gamestages.data.IStageData;
import net.minecraft.entity.player.EntityPlayer;

public class GameStageHelperNoEvent{

    /**
     * 这个类的所有方法，均只能用来单纯获取阶段，无法通过事件访问结果和修改存在阶段
     * 检查玩家是否拥有指定阶段（无事件触发版本）
     *
     * @param player 要检查的玩家实体
     * @param stage 要检查的游戏阶段名称
     * @return 如果玩家拥有该阶段则返回 true
     */
    public static boolean hasStageSilent(EntityPlayer player, String stage) {
        final IStageData data = GameStageHelper.getPlayerData(player);
        return hasStageSilent(player, data, stage);
    }

    /**
     * 检查玩家是否拥有指定阶段（无事件触发版本）
     *
     * @param player 要检查的玩家实体
     * @param data 玩家的阶段数据
     * @param stage 要检查的游戏阶段名称
     * @return 如果玩家拥有该阶段则返回 true
     */
    public static boolean hasStageSilent(EntityPlayer player, IStageData data, String stage) {
        return data != null && data.hasStage(stage);
    }

    /**
     * 检查玩家是否拥有任意指定阶段（无事件触发版本）
     *
     * @param player 要检查的玩家实体
     * @param stages 要检查的阶段数组
     * @return 如果玩家拥有任意指定阶段则返回 true
     */
    public static boolean hasAnyStageSilent(EntityPlayer player, String... stages) {
        final IStageData data = GameStageHelper.getPlayerData(player);
        return hasAnyStageSilent(player, data, stages);
    }

    /**
     * 检查玩家是否拥有任意指定阶段（无事件触发版本）
     *
     * @param player 要检查的玩家实体
     * @param data 玩家的阶段数据
     * @param stages 要检查的阶段数组
     * @return 如果玩家拥有任意指定阶段则返回 true
     */
    public static boolean hasAnyStageSilent(EntityPlayer player, IStageData data, String... stages) {
        if (data == null) return false;
        for (String stage : stages) {
            if (data.hasStage(stage)) return true;
        }
        return false;
    }

    /**
     * 检查玩家是否拥有所有指定阶段（无事件触发版本）
     *
     * @param player 要检查的玩家实体
     * @param stages 要检查的阶段数组
     * @return 如果玩家拥有所有指定阶段则返回 true
     */
    public static boolean hasAllStagesSilent(EntityPlayer player, String... stages) {
        final IStageData data = GameStageHelper.getPlayerData(player);
        return hasAllStagesSilent(player, data, stages);
    }

    /**
     * 检查玩家是否拥有所有指定阶段（无事件触发版本）
     *
     * @param player 要检查的玩家实体
     * @param data 玩家的阶段数据
     * @param stages 要检查的阶段数组
     * @return 如果玩家拥有所有指定阶段则返回 true
     */
    public static boolean hasAllStagesSilent(EntityPlayer player, IStageData data, String... stages) {
        if (data == null) return false;
        for (String stage : stages) {
            if (!data.hasStage(stage)) return false;
        }
        return true;
    }
}
