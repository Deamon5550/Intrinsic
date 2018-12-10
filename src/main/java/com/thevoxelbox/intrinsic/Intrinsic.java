package com.thevoxelbox.intrinsic;

public class Intrinsic {

    static {
        System.loadLibrary("intrinsic");
    }

    public static native long rdtsc();

}
