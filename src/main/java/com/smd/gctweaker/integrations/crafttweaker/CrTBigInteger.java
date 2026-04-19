package com.smd.gctweaker.integrations.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.math.BigInteger;
import java.util.Random;

@ZenRegister
@ZenClass("mods.gctweaker.math.CrTBigInteger")
public final class CrTBigInteger {

    private CrTBigInteger() {
    }

    @ZenMethod
    public static BigInteger zero() {
        return BigInteger.ZERO;
    }

    @ZenMethod
    public static BigInteger one() {
        return BigInteger.ONE;
    }

    @ZenMethod
    public static BigInteger ten() {
        return BigInteger.TEN;
    }

    @ZenMethod
    public static BigInteger create(byte[] value) {
        return new BigInteger(value);
    }

    @ZenMethod
    public static BigInteger create(int signum, byte[] magnitude) {
        return new BigInteger(signum, magnitude);
    }

    @ZenMethod
    public static BigInteger create(String value, int radix) {
        return new BigInteger(value, radix);
    }

    @ZenMethod
    public static BigInteger create(String value) {
        return new BigInteger(value);
    }

    @ZenMethod
    public static BigInteger create(int numBits, Random random) {
        return new BigInteger(numBits, random);
    }

    @ZenMethod
    public static BigInteger create(int bitLength, int certainty, Random random) {
        return new BigInteger(bitLength, certainty, random);
    }

    @ZenMethod
    public static BigInteger probablePrime(int bitLength, Random random) {
        return BigInteger.probablePrime(bitLength, random);
    }

    @ZenMethod
    public static BigInteger valueOf(long value) {
        return BigInteger.valueOf(value);
    }

    @ZenMethod
    public static BigInteger nextProbablePrime(BigInteger value) {
        return value.nextProbablePrime();
    }

    @ZenMethod
    public static BigInteger add(BigInteger value, BigInteger augend) {
        return value.add(augend);
    }

    @ZenMethod
    public static BigInteger subtract(BigInteger value, BigInteger subtrahend) {
        return value.subtract(subtrahend);
    }

    @ZenMethod
    public static BigInteger multiply(BigInteger value, BigInteger multiplicand) {
        return value.multiply(multiplicand);
    }

    @ZenMethod
    public static BigInteger divide(BigInteger value, BigInteger divisor) {
        return value.divide(divisor);
    }

    @ZenMethod
    public static BigInteger[] divideAndRemainder(BigInteger value, BigInteger divisor) {
        return value.divideAndRemainder(divisor);
    }

    @ZenMethod
    public static BigInteger remainder(BigInteger value, BigInteger divisor) {
        return value.remainder(divisor);
    }

    @ZenMethod
    public static BigInteger pow(BigInteger value, int exponent) {
        return value.pow(exponent);
    }

    @ZenMethod
    public static BigInteger gcd(BigInteger value, BigInteger other) {
        return value.gcd(other);
    }

    @ZenMethod
    public static BigInteger abs(BigInteger value) {
        return value.abs();
    }

    @ZenMethod
    public static BigInteger negate(BigInteger value) {
        return value.negate();
    }

    @ZenMethod
    public static int signum(BigInteger value) {
        return value.signum();
    }

    @ZenMethod
    public static BigInteger mod(BigInteger value, BigInteger modulus) {
        return value.mod(modulus);
    }

    @ZenMethod
    public static BigInteger modPow(BigInteger value, BigInteger exponent, BigInteger modulus) {
        return value.modPow(exponent, modulus);
    }

    @ZenMethod
    public static BigInteger modInverse(BigInteger value, BigInteger modulus) {
        return value.modInverse(modulus);
    }

    @ZenMethod
    public static BigInteger shiftLeft(BigInteger value, int distance) {
        return value.shiftLeft(distance);
    }

    @ZenMethod
    public static BigInteger shiftRight(BigInteger value, int distance) {
        return value.shiftRight(distance);
    }

    @ZenMethod
    public static BigInteger and(BigInteger value, BigInteger other) {
        return value.and(other);
    }

    @ZenMethod
    public static BigInteger or(BigInteger value, BigInteger other) {
        return value.or(other);
    }

    @ZenMethod
    public static BigInteger xor(BigInteger value, BigInteger other) {
        return value.xor(other);
    }

    @ZenMethod
    public static BigInteger not(BigInteger value) {
        return value.not();
    }

    @ZenMethod
    public static BigInteger andNot(BigInteger value, BigInteger other) {
        return value.andNot(other);
    }

    @ZenMethod
    public static boolean testBit(BigInteger value, int index) {
        return value.testBit(index);
    }

    @ZenMethod
    public static BigInteger setBit(BigInteger value, int index) {
        return value.setBit(index);
    }

    @ZenMethod
    public static BigInteger clearBit(BigInteger value, int index) {
        return value.clearBit(index);
    }

    @ZenMethod
    public static BigInteger flipBit(BigInteger value, int index) {
        return value.flipBit(index);
    }

    @ZenMethod
    public static int getLowestSetBit(BigInteger value) {
        return value.getLowestSetBit();
    }

    @ZenMethod
    public static int bitLength(BigInteger value) {
        return value.bitLength();
    }

    @ZenMethod
    public static int bitCount(BigInteger value) {
        return value.bitCount();
    }

    @ZenMethod
    public static boolean isProbablePrime(BigInteger value, int certainty) {
        return value.isProbablePrime(certainty);
    }

    @ZenMethod
    public static int compareTo(BigInteger value, BigInteger other) {
        return value.compareTo(other);
    }

    @ZenMethod
    public static boolean equals(BigInteger value, Object other) {
        return value.equals(other);
    }

    @ZenMethod
    public static BigInteger min(BigInteger value, BigInteger other) {
        return value.min(other);
    }

    @ZenMethod
    public static BigInteger max(BigInteger value, BigInteger other) {
        return value.max(other);
    }

    @ZenMethod
    public static int hashCode(BigInteger value) {
        return value.hashCode();
    }

    @ZenMethod
    public static String toString(BigInteger value, int radix) {
        return value.toString(radix);
    }

    @ZenMethod
    public static String toString(BigInteger value) {
        return value.toString();
    }

    @ZenMethod
    public static byte[] toByteArray(BigInteger value) {
        return value.toByteArray();
    }

    @ZenMethod
    public static int intValue(BigInteger value) {
        return value.intValue();
    }

    @ZenMethod
    public static long longValue(BigInteger value) {
        return value.longValue();
    }

    @ZenMethod
    public static float floatValue(BigInteger value) {
        return value.floatValue();
    }

    @ZenMethod
    public static double doubleValue(BigInteger value) {
        return value.doubleValue();
    }

    @ZenMethod
    public static long longValueExact(BigInteger value) {
        return value.longValueExact();
    }

    @ZenMethod
    public static int intValueExact(BigInteger value) {
        return value.intValueExact();
    }

    @ZenMethod
    public static short shortValueExact(BigInteger value) {
        return value.shortValueExact();
    }

    @ZenMethod
    public static byte byteValueExact(BigInteger value) {
        return value.byteValueExact();
    }
}
