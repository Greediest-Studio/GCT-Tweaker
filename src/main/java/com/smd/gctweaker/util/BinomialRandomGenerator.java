package com.smd.gctweaker.util;

import java.util.concurrent.ThreadLocalRandom;

public class BinomialRandomGenerator {

    public static int generate(int n, float p) {
        return generate(n, (double) p);
    }

    public static int generate(int n, double p) {
        if (n <= 0 || Double.isNaN(p) || p <= 0.0) {
            return 0;
        }
        if (p >= 1.0) {
            return n;
        }

        if (p > 0.5) {
            return n - sampleByWaitingTime(n, 1.0 - p);
        }
        return sampleByWaitingTime(n, p);
    }

    private static int sampleByWaitingTime(int n, double p) {
        double logFailureProbability = Math.log1p(-p);
        int remaining = n;
        int successes = 0;

        while (remaining > 0) {
            double random = ThreadLocalRandom.current().nextDouble();
            int failuresBeforeNextSuccess = (int) (Math.log(random) / logFailureProbability);

            if (failuresBeforeNextSuccess >= remaining) {
                break;
            }

            successes++;
            remaining -= failuresBeforeNextSuccess + 1;
        }

        return successes;
    }
}
