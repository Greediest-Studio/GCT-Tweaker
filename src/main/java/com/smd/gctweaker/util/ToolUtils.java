package com.smd.gctweaker.util;

import crafttweaker.api.block.IBlock;

public class ToolUtils {

    public static boolean isValidBlock(IBlock block) {
        return block != null && !block.getDefinition().getId().equals("minecraft:air");
    }
}
