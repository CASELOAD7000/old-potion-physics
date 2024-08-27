package me.caseload.oldpotionphysics.util;

import java.util.Random;

public class MathHelper {

    private static final float[] SINE_TABLE = new float[65536];
    private static final Random random = new Random();

    static {
        for (int i = 0; i < SINE_TABLE.length; i++) {
            SINE_TABLE[i] = (float) Math.sin(i * Math.PI * 2.0 / 65536.0);
        }
    }

    public static double nextTriangular(double mode, double deviation) {
        return mode + deviation * (random.nextDouble() - random.nextDouble());
    }

    public static float sin(float value) {
        return SINE_TABLE[(int) (value * 10430.378F) & 0xFFFF];
    }

    public static float cos(float value) {
        return SINE_TABLE[(int) (value * 10430.378F + 16384.0F) & 0xFFFF];
    }
}