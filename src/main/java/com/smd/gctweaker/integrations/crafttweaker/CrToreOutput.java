package com.smd.gctweaker.integrations.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ZenRegister
@ZenClass("mods.gctweaker.oreOutput")
public class CrToreOutput {
    private static final Map<String, Map<String, List<CrToreOutput>>> oreMap = new LinkedHashMap<>();
    private static final Map<Integer, String> dimList = new LinkedHashMap<>();

    private final String dimName;
    private final int dimId;
    private final String upgrade;
    private final IItemStack ore;
    private final int amount;
    private final float chance;

    public CrToreOutput(String dimName, int dimId, String upgrade, IItemStack ore, int amount, float chance) {
        this.dimName = dimName;
        this.dimId = dimId;
        this.upgrade = upgrade;
        this.ore = ore;
        this.amount = amount;
        this.chance = chance;
    }

    @ZenMethod
    public static CrToreOutput create(String dimName, int dimId, String upgrade, IItemStack ore, int amount, float chance) {
        addToDimList(dimId, dimName);
        CrToreOutput output = new CrToreOutput(dimName, dimId, upgrade, ore, amount, chance);
        output.addToOreMap();

        CraftTweakerAPI.getLogger().logInfo("创建oreOutput实例: \n维度名称/维度Id：" + dimName + "/" + dimId + "\n所需升级：" + upgrade +
                "\n矿物：" + (ore == null ? "null" : ore.getDisplayName()) + "\n数量：" + amount + "\n几率：" + chance);

        return output;
    }

    private static void addToDimList(int dimId, String dimName) {
        if (!dimList.containsKey(dimId)) {
            dimList.put(dimId, dimName);
            //CraftTweakerAPI.getLogger().logInfo("添加维度至 dimList[dimId=" + dimId + ", dimName=" + dimName + "]");
        }
    }

    private void addToOreMap() {
        String dimKey = String.valueOf(this.dimId);
        oreMap.computeIfAbsent(dimKey, k -> new LinkedHashMap<>())
                .computeIfAbsent(this.upgrade, k -> new ArrayList<>())
                .add(this);

        //CraftTweakerAPI.getLogger().logInfo("添加至 oreMap[dimKey=" + dimKey + "][upgrade=" + this.upgrade +
        //        "]，当前长度: " + oreMap.get(dimKey).get(this.upgrade).size());
    }

    @ZenMethod
    public static String[] getUpgradeList(int dimId) {
        String dimKey = String.valueOf(dimId);
        Map<String, List<CrToreOutput>> upgradeMap = oreMap.get(dimKey);

        if (upgradeMap == null) {
            return new String[0];
        }

        return upgradeMap.keySet().toArray(new String[0]);
    }

    @ZenMethod
    public static CrToreOutput[] getoreList(int dimId, String upgrade) {
        String dimKey = String.valueOf(dimId);
        Map<String, List<CrToreOutput>> upgradeMap = oreMap.get(dimKey);

        if (upgradeMap == null) {
            return new CrToreOutput[0];
        }

        List<CrToreOutput> oreOutputs = upgradeMap.get(upgrade);
        if (oreOutputs == null || oreOutputs.isEmpty()) {
            return new CrToreOutput[0];
        }

        return oreOutputs.toArray(new CrToreOutput[0]);
    }

    @ZenMethod
    public static Map<Integer, String> getDimList() {
        return dimList;
    }

    @ZenMethod
    public static String getDimName(int dimId) {
        return dimList.get(dimId);
    }


    @ZenMethod
    public static String getdimName(int dimId) {
        return dimList.get(dimId) == null ? ("该维度不可挖掘，维度id：" + dimId) : dimList.get(dimId);
    }

    @ZenMethod
    public static IItemStack[] getOreOutputList(int dimId, String upgrade, int parallel, @Optional("false") Boolean test) {
        String dimKey = String.valueOf(dimId);
        Map<String, List<CrToreOutput>> upgradeMap = oreMap.get(dimKey);

        if (upgradeMap == null) {
            if (test) {
                CraftTweakerAPI.getLogger().logInfo("该维度无矿物: " + dimId);
            }
            return new IItemStack[0];
        }

        List<CrToreOutput> oreOutputs = upgradeMap.get(upgrade);
        if (oreOutputs == null || oreOutputs.isEmpty()) {
            if (test) {
                CraftTweakerAPI.getLogger().logInfo("该等级无矿物，维度: " + dimId + "，等级: " + upgrade);
            }
            return new IItemStack[0];
        }

        List<IItemStack> result = new ArrayList<>();

        for (CrToreOutput oreOutput : oreOutputs) {
            int n = oreOutput.amount * parallel;

            int x = test ? n : com.smd.gctweaker.util.BinomialRandomGenerator.generate(n, oreOutput.chance);

            if (x > 0 && oreOutput.ore != null) {
                IItemStack outputStack = oreOutput.ore.withAmount(x);
                result.add(outputStack);
            }
        }

        return result.toArray(new IItemStack[0]);
    }

    @ZenGetter("dimName")
    public String getDimName() {
        return dimName;
    }

    @ZenGetter("dimId")
    public int getDimId() {
        return dimId;
    }

    @ZenGetter("upgrade")
    public String getUpgrade() {
        return upgrade;
    }

    @ZenGetter("ore")
    public IItemStack getOre() {
        if (ore == null) {
            CraftTweakerAPI.getLogger().logInfo("ore为空，维度: " + dimId + "，升级: " + upgrade);
        }
        return ore;
    }

    @ZenGetter("amount")
    public int getAmount() {
        return amount;
    }

    @ZenGetter("chance")
    public float getChance() {
        return chance;
    }
}
