package com.smd.gctweaker.integrations.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.math.RoundingMode;

@ZenRegister
@ZenClass("mods.gctweaker.math.CrTRoundingMode")
public final class CrTRoundingMode {

    private CrTRoundingMode() {
    }

    @ZenMethod
    public static RoundingMode up() {
        return RoundingMode.UP;
    }

    @ZenMethod
    public static RoundingMode down() {
        return RoundingMode.DOWN;
    }

    @ZenMethod
    public static RoundingMode ceiling() {
        return RoundingMode.CEILING;
    }

    @ZenMethod
    public static RoundingMode floor() {
        return RoundingMode.FLOOR;
    }

    @ZenMethod
    public static RoundingMode halfUp() {
        return RoundingMode.HALF_UP;
    }

    @ZenMethod
    public static RoundingMode halfDown() {
        return RoundingMode.HALF_DOWN;
    }

    @ZenMethod
    public static RoundingMode halfEven() {
        return RoundingMode.HALF_EVEN;
    }

    @ZenMethod
    public static RoundingMode unnecessary() {
        return RoundingMode.UNNECESSARY;
    }

    @ZenMethod
    public static RoundingMode[] values() {
        return RoundingMode.values();
    }

    @ZenMethod
    public static RoundingMode valueOf(String name) {
        return RoundingMode.valueOf(name);
    }

    @ZenMethod
    public static RoundingMode valueOf(int mode) {
        return RoundingMode.valueOf(mode);
    }

    @ZenMethod
    public static String name(RoundingMode mode) {
        return mode.name();
    }

    @ZenMethod
    public static int ordinal(RoundingMode mode) {
        return mode.ordinal();
    }

    @ZenMethod
    public static String toString(RoundingMode mode) {
        return mode.toString();
    }
}
