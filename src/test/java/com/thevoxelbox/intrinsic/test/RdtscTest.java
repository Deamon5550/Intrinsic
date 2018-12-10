package com.thevoxelbox.intrinsic.test;

import com.thevoxelbox.intrinsic.Intrinsic;
import org.junit.Test;

public class RdtscTest {

    @Test
    public void rdtscTest() {
        for (int i = 0; i < 10000; i++) {
            Intrinsic.rdtsc();
        }
        long start = System.nanoTime();
        long a = Intrinsic.rdtsc();
        for (int i = 0; i < 100000000; i++) {
            Intrinsic.rdtsc();
        }
        long b = Intrinsic.rdtsc();
        long end = System.nanoTime();
        long delta = end - start;
        long delta_ticks = b - a;
        System.out.println("Time per call: " + (delta / 100000002) + "ns");
        double ticks_per_ns = delta_ticks / (double) delta;
        System.out.println("Clock frequency: " + ticks_per_ns + "GHz");
        for (int i = 0; i < 100; i++) {
            long a0 = Intrinsic.rdtsc();
            long b0 = Intrinsic.rdtsc();
            System.out.println("" + (b0 - a0));
            System.out.println("" + ((b0 - a0) / ticks_per_ns));
        }
    }

    @Test
    public void nanoTimeIncrementTest() {
        for (int i = 0; i < 10; i++) {
            long a0 = System.nanoTime();
            long b0 = System.nanoTime();
            System.out.println("" + (b0 - a0));
        }
    }

}
