package com.smd.gctweaker.integrations.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.math.MathContext;
import java.math.RoundingMode;

@ZenRegister
@ZenClass("mods.gctweaker.math.CrTMathContext")
public final class CrTMathContext {

    private CrTMathContext() {
    }

    @ZenMethod
    public static MathContext unlimited() {
        return MathContext.UNLIMITED;
    }

    @ZenMethod
    public static MathContext decimal32() {
        return MathContext.DECIMAL32;
    }

    @ZenMethod
    public static MathContext decimal64() {
        return MathContext.DECIMAL64;
    }

    @ZenMethod
    public static MathContext decimal128() {
        return MathContext.DECIMAL128;
    }

    @ZenMethod
    public static MathContext create(int precision) {
        return new MathContext(precision);
    }

    @ZenMethod
    public static MathContext create(int precision, RoundingMode roundingMode) {
        return new MathContext(precision, roundingMode);
    }

    @ZenMethod
    public static MathContext create(String value) {
        return new MathContext(value);
    }

    @ZenMethod
    public static int precision(MathContext context) {
        return context.getPrecision();
    }

    @ZenMethod
    public static RoundingMode roundingMode(MathContext context) {
        return context.getRoundingMode();
    }

    @ZenMethod
    public static boolean equals(MathContext context, Object other) {
        return context.equals(other);
    }

    @ZenMethod
    public static int hashCode(MathContext context) {
        return context.hashCode();
    }

    @ZenMethod
    public static String toString(MathContext context) {
        return context.toString();
    }
}
