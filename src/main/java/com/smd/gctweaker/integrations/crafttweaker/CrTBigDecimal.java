package com.smd.gctweaker.integrations.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

@ZenRegister
@ZenClass("mods.gctweaker.math.CrTBigDecimal")
public final class CrTBigDecimal {

    private CrTBigDecimal() {
    }

    @ZenMethod
    public static BigDecimal zero() {
        return BigDecimal.ZERO;
    }

    @ZenMethod
    public static BigDecimal one() {
        return BigDecimal.ONE;
    }

    @ZenMethod
    public static BigDecimal ten() {
        return BigDecimal.TEN;
    }

    @ZenMethod
    public static int roundUp() {
        return BigDecimal.ROUND_UP;
    }

    @ZenMethod
    public static int roundDown() {
        return BigDecimal.ROUND_DOWN;
    }

    @ZenMethod
    public static int roundCeiling() {
        return BigDecimal.ROUND_CEILING;
    }

    @ZenMethod
    public static int roundFloor() {
        return BigDecimal.ROUND_FLOOR;
    }

    @ZenMethod
    public static int roundHalfUp() {
        return BigDecimal.ROUND_HALF_UP;
    }

    @ZenMethod
    public static int roundHalfDown() {
        return BigDecimal.ROUND_HALF_DOWN;
    }

    @ZenMethod
    public static int roundHalfEven() {
        return BigDecimal.ROUND_HALF_EVEN;
    }

    @ZenMethod
    public static int roundUnnecessary() {
        return BigDecimal.ROUND_UNNECESSARY;
    }

    @ZenMethod
    public static BigDecimal create(char[] value, int offset, int length) {
        return new BigDecimal(value, offset, length);
    }

    @ZenMethod
    public static BigDecimal create(char[] value, int offset, int length, MathContext context) {
        return new BigDecimal(value, offset, length, context);
    }

    @ZenMethod
    public static BigDecimal create(char[] value) {
        return new BigDecimal(value);
    }

    @ZenMethod
    public static BigDecimal create(char[] value, MathContext context) {
        return new BigDecimal(value, context);
    }

    @ZenMethod
    public static BigDecimal create(String value) {
        return new BigDecimal(value);
    }

    @ZenMethod
    public static BigDecimal create(String value, MathContext context) {
        return new BigDecimal(value, context);
    }

    @ZenMethod
    public static BigDecimal create(double value) {
        return new BigDecimal(value);
    }

    @ZenMethod
    public static BigDecimal create(double value, MathContext context) {
        return new BigDecimal(value, context);
    }

    @ZenMethod
    public static BigDecimal create(BigInteger value) {
        return new BigDecimal(value);
    }

    @ZenMethod
    public static BigDecimal create(BigInteger value, MathContext context) {
        return new BigDecimal(value, context);
    }

    @ZenMethod
    public static BigDecimal create(BigInteger value, int scale) {
        return new BigDecimal(value, scale);
    }

    @ZenMethod
    public static BigDecimal create(BigInteger value, int scale, MathContext context) {
        return new BigDecimal(value, scale, context);
    }

    @ZenMethod
    public static BigDecimal create(int value) {
        return new BigDecimal(value);
    }

    @ZenMethod
    public static BigDecimal create(int value, MathContext context) {
        return new BigDecimal(value, context);
    }

    @ZenMethod
    public static BigDecimal create(long value) {
        return new BigDecimal(value);
    }

    @ZenMethod
    public static BigDecimal create(long value, MathContext context) {
        return new BigDecimal(value, context);
    }

    @ZenMethod
    public static BigDecimal valueOf(long value, int scale) {
        return BigDecimal.valueOf(value, scale);
    }

    @ZenMethod
    public static BigDecimal valueOf(long value) {
        return BigDecimal.valueOf(value);
    }

    @ZenMethod
    public static BigDecimal valueOf(double value) {
        return BigDecimal.valueOf(value);
    }

    @ZenMethod
    public static BigDecimal add(BigDecimal value, BigDecimal augend) {
        return value.add(augend);
    }

    @ZenMethod
    public static BigDecimal add(BigDecimal value, BigDecimal augend, MathContext context) {
        return value.add(augend, context);
    }

    @ZenMethod
    public static BigDecimal subtract(BigDecimal value, BigDecimal subtrahend) {
        return value.subtract(subtrahend);
    }

    @ZenMethod
    public static BigDecimal subtract(BigDecimal value, BigDecimal subtrahend, MathContext context) {
        return value.subtract(subtrahend, context);
    }

    @ZenMethod
    public static BigDecimal multiply(BigDecimal value, BigDecimal multiplicand) {
        return value.multiply(multiplicand);
    }

    @ZenMethod
    public static BigDecimal multiply(BigDecimal value, BigDecimal multiplicand, MathContext context) {
        return value.multiply(multiplicand, context);
    }

    @ZenMethod
    public static BigDecimal divide(BigDecimal value, BigDecimal divisor, int scale, int roundingMode) {
        return value.divide(divisor, scale, roundingMode);
    }

    @ZenMethod
    public static BigDecimal divide(BigDecimal value, BigDecimal divisor, int scale, RoundingMode roundingMode) {
        return value.divide(divisor, scale, roundingMode);
    }

    @ZenMethod
    public static BigDecimal divide(BigDecimal value, BigDecimal divisor, int roundingMode) {
        return value.divide(divisor, roundingMode);
    }

    @ZenMethod
    public static BigDecimal divide(BigDecimal value, BigDecimal divisor, RoundingMode roundingMode) {
        return value.divide(divisor, roundingMode);
    }

    @ZenMethod
    public static BigDecimal divide(BigDecimal value, BigDecimal divisor) {
        return value.divide(divisor);
    }

    @ZenMethod
    public static BigDecimal divide(BigDecimal value, BigDecimal divisor, MathContext context) {
        return value.divide(divisor, context);
    }

    @ZenMethod
    public static BigDecimal divideToIntegralValue(BigDecimal value, BigDecimal divisor) {
        return value.divideToIntegralValue(divisor);
    }

    @ZenMethod
    public static BigDecimal divideToIntegralValue(BigDecimal value, BigDecimal divisor, MathContext context) {
        return value.divideToIntegralValue(divisor, context);
    }

    @ZenMethod
    public static BigDecimal remainder(BigDecimal value, BigDecimal divisor) {
        return value.remainder(divisor);
    }

    @ZenMethod
    public static BigDecimal remainder(BigDecimal value, BigDecimal divisor, MathContext context) {
        return value.remainder(divisor, context);
    }

    @ZenMethod
    public static BigDecimal[] divideAndRemainder(BigDecimal value, BigDecimal divisor) {
        return value.divideAndRemainder(divisor);
    }

    @ZenMethod
    public static BigDecimal[] divideAndRemainder(BigDecimal value, BigDecimal divisor, MathContext context) {
        return value.divideAndRemainder(divisor, context);
    }

    @ZenMethod
    public static BigDecimal pow(BigDecimal value, int exponent) {
        return value.pow(exponent);
    }

    @ZenMethod
    public static BigDecimal pow(BigDecimal value, int exponent, MathContext context) {
        return value.pow(exponent, context);
    }

    @ZenMethod
    public static BigDecimal abs(BigDecimal value) {
        return value.abs();
    }

    @ZenMethod
    public static BigDecimal abs(BigDecimal value, MathContext context) {
        return value.abs(context);
    }

    @ZenMethod
    public static BigDecimal negate(BigDecimal value) {
        return value.negate();
    }

    @ZenMethod
    public static BigDecimal negate(BigDecimal value, MathContext context) {
        return value.negate(context);
    }

    @ZenMethod
    public static BigDecimal plus(BigDecimal value) {
        return value.plus();
    }

    @ZenMethod
    public static BigDecimal plus(BigDecimal value, MathContext context) {
        return value.plus(context);
    }

    @ZenMethod
    public static int signum(BigDecimal value) {
        return value.signum();
    }

    @ZenMethod
    public static int scale(BigDecimal value) {
        return value.scale();
    }

    @ZenMethod
    public static int precision(BigDecimal value) {
        return value.precision();
    }

    @ZenMethod
    public static BigInteger unscaledValue(BigDecimal value) {
        return value.unscaledValue();
    }

    @ZenMethod
    public static BigDecimal round(BigDecimal value, MathContext context) {
        return value.round(context);
    }

    @ZenMethod
    public static BigDecimal setScale(BigDecimal value, int newScale, RoundingMode roundingMode) {
        return value.setScale(newScale, roundingMode);
    }

    @ZenMethod
    public static BigDecimal setScale(BigDecimal value, int newScale, int roundingMode) {
        return value.setScale(newScale, roundingMode);
    }

    @ZenMethod
    public static BigDecimal setScale(BigDecimal value, int newScale) {
        return value.setScale(newScale);
    }

    @ZenMethod
    public static BigDecimal movePointLeft(BigDecimal value, int distance) {
        return value.movePointLeft(distance);
    }

    @ZenMethod
    public static BigDecimal movePointRight(BigDecimal value, int distance) {
        return value.movePointRight(distance);
    }

    @ZenMethod
    public static BigDecimal scaleByPowerOfTen(BigDecimal value, int distance) {
        return value.scaleByPowerOfTen(distance);
    }

    @ZenMethod
    public static BigDecimal stripTrailingZeros(BigDecimal value) {
        return value.stripTrailingZeros();
    }

    @ZenMethod
    public static int compareTo(BigDecimal value, BigDecimal other) {
        return value.compareTo(other);
    }

    @ZenMethod
    public static boolean equals(BigDecimal value, Object other) {
        return value.equals(other);
    }

    @ZenMethod
    public static BigDecimal min(BigDecimal value, BigDecimal other) {
        return value.min(other);
    }

    @ZenMethod
    public static BigDecimal max(BigDecimal value, BigDecimal other) {
        return value.max(other);
    }

    @ZenMethod
    public static int hashCode(BigDecimal value) {
        return value.hashCode();
    }

    @ZenMethod
    public static String toString(BigDecimal value) {
        return value.toString();
    }

    @ZenMethod
    public static String toEngineeringString(BigDecimal value) {
        return value.toEngineeringString();
    }

    @ZenMethod
    public static String toPlainString(BigDecimal value) {
        return value.toPlainString();
    }

    @ZenMethod
    public static BigInteger toBigInteger(BigDecimal value) {
        return value.toBigInteger();
    }

    @ZenMethod
    public static BigInteger toBigIntegerExact(BigDecimal value) {
        return value.toBigIntegerExact();
    }

    @ZenMethod
    public static long longValue(BigDecimal value) {
        return value.longValue();
    }

    @ZenMethod
    public static long longValueExact(BigDecimal value) {
        return value.longValueExact();
    }

    @ZenMethod
    public static int intValue(BigDecimal value) {
        return value.intValue();
    }

    @ZenMethod
    public static int intValueExact(BigDecimal value) {
        return value.intValueExact();
    }

    @ZenMethod
    public static short shortValueExact(BigDecimal value) {
        return value.shortValueExact();
    }

    @ZenMethod
    public static byte byteValueExact(BigDecimal value) {
        return value.byteValueExact();
    }

    @ZenMethod
    public static float floatValue(BigDecimal value) {
        return value.floatValue();
    }

    @ZenMethod
    public static double doubleValue(BigDecimal value) {
        return value.doubleValue();
    }

    @ZenMethod
    public static BigDecimal ulp(BigDecimal value) {
        return value.ulp();
    }
}
