package com.smd.gctweaker.util;

import java.util.Random;

public class BinomialRandomGenerator {

    private static final Random RANDOM = new Random();

    private static final int DIRECT_THRESHOLD = 25;
    private static final double POISSON_THRESHOLD = 10.0;

    public static int generate(int n, double p) {
        if (n <= 0 || p <= 0.0) {
            return 0;
        }
        if (p >= 1.0) {
            return n;
        }

        double np = n * p;
        double nq = n * (1.0 - p);

        if (n <= DIRECT_THRESHOLD) {
            return directMethod(n, p);
        } else if (np < POISSON_THRESHOLD || nq < POISSON_THRESHOLD) {
            return inverseTransformMethod(n, p);
        } else {
            return btpeAlgorithm(n, p);
        }
    }

    private static int directMethod(int n, double p) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (RANDOM.nextDouble() < p) {
                count++;
            }
        }
        return count;
    }

    private static int inverseTransformMethod(int n, double p) {
        boolean swapped = false;
        double q = 1.0 - p;

        if (p > 0.5) {
            p = q;
            q = 1.0 - p;
            swapped = true;
        }

        double u = RANDOM.nextDouble();
        int x = 0;

        double logF0 = n * Math.log(q);
        if (logF0 < -700) {
            logF0 = -700;
        }
        double f = Math.exp(logF0);
        double cumulativeProb = f;

        while (u > cumulativeProb) {
            x++;
            if (x > n) {
                break;
            }
            f *= ((n - x + 1.0) / x) * (p / q);
            cumulativeProb += f;
        }

        return swapped ? n - x : x;
    }

    private static int btpeAlgorithm(int n, double p) {
        boolean swapped = false;
        double q = 1.0 - p;

        if (p > 0.5) {
            p = q;
            q = 1.0 - p;
            swapped = true;
        }

        double np = n * p;
        double nsq = Math.sqrt(n * p * q);

        double m = Math.floor((n + 1) * p);

        double a = m + 0.5;
        double b = 1.15 + 2.53 * nsq;
        double c = -0.0873 + 0.0248 * b + 0.01 * p;
        double alpha = (2.83 + 5.1 / nsq) * nsq;
        double d = alpha + 0.43;

        double s = p / q;
        double r = q / p;

        while (true) {
            double u = RANDOM.nextDouble() - 0.5;
            double v = RANDOM.nextDouble();

            double us = 0.5 - Math.abs(u);
            double k = Math.floor((2 * a / us + b) * u + m + 0.43);

            if (k < 0 || k > n) {
                continue;
            }

            double t = (b * us + c) * Math.abs(u);

            if (t <= d) {
                double rho = (c * us / (v * alpha) + c / d) * (d / (alpha * v));
                if (v <= rho) {
                    return swapped ? n - (int) k : (int) k;
                }
                continue;
            }

            double y = Math.abs(u);
            double e = Math.exp(-y * y / (2 * nsq * nsq));

            if (v <= e) {
                return swapped ? n - (int) k : (int) k;
            }

            double logV = Math.log(v);
            double h = (m + 0.5) * Math.log((m + 1.0) / (n - m + 1.0));
            double g = lgamma(n + 1) - lgamma(k + 1) - lgamma(n - k + 1);
            double logRho = h + g + k * Math.log(s) + (n - k) * Math.log(r);

            if (logV <= logRho) {
                return swapped ? n - (int) k : (int) k;
            }
        }
    }

    private static double lgamma(double x) {
        if (x <= 0) {
            return Double.NaN;
        }

        double[] coeff = {
                76.18009172947146,
                -86.50532032941677,
                24.01409824083091,
                -1.231739572450155,
                0.1208650973866179e-2,
                -0.5395239384953e-5
        };

        double y = x;
        double tmp = x + 5.5;
        tmp -= (x - 0.5) * Math.log(tmp);
        double ser = 1.000000000190015;

        for (double c : coeff) {
            ser += c / y;
            y += 1;
        }

        return -tmp + Math.log(2.5066282746310005 * ser / x);
    }
}
