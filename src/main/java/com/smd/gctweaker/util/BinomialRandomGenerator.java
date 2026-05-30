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

        if (n < DIRECT_THRESHOLD) {
            return directMethod(n, p);
        } else if (np < POISSON_THRESHOLD || nq < POISSON_THRESHOLD) {
            return inverseTransformMethod(n, p);
        } else {
            return btepAlgorithm(n, p);
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
        double q = 1.0 - p;
        if (p > 0.5) {
            p = q;
            q = 1.0 - q;
        }

        double r = Math.log(q / p);
        double u = RANDOM.nextDouble();
        int x = 0;
        double f = Math.pow(q, n);
        double sum = f;

        while (u > sum) {
            x++;
            f *= ((n - x + 1.0) / x) * (p / q);
            sum += f;
        }

        return p != q ? n - x : x;
    }

    private static int btepAlgorithm(int n, double p) {
        double q = 1.0 - p;
        double np = n * p;
        double nsq = Math.sqrt(n * p * q);

        double alpha = (2.83 + 5.1 / nsq) * nsq;
        double m = Math.floor((n + 1) * p);

        double a = m + 0.5;
        double b = 1.15 + 2.53 * nsq;
        double c = -0.0873 + 0.0248 * b + 0.01 * p;
        double d = alpha + 0.43;

        double s = p / q;
        double r = q / p;

        while (true) {
            double u = RANDOM.nextDouble();
            double v = RANDOM.nextDouble();
            double uStar = u - 0.5;
            double us = 0.5 - Math.abs(uStar);

            double k = Math.floor((2 * a / us + b) * uStar + m + 0.43);

            if (k < 0 || k > n) {
                continue;
            }

            double rho = (c * us / (v * alpha) + c / d) * (d / (alpha * v));
            double t = (b * us + c) * Math.abs(uStar);

            if (t < d && v < rho) {
                return (int) k;
            }

            double y = Math.abs(uStar);
            double e = Math.exp(-y * y / (2 * nsq * nsq));

            if (v < e) {
                return (int) k;
            }

            double h = (m + 0.5) * Math.log((m + 1.0) / (n - m + 1.0));
            double g = n * Math.log(n) - k * Math.log(k) - (n - k) * Math.log(n - k);
            double logRho = h + g - k * Math.log(s) - (n - k) * Math.log(r);

            if (Math.log(v) < logRho) {
                return (int) k;
            }
        }
    }
}
