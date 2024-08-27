package me.caseload.oldpotionphysics.util;

import java.util.Random;

public class MathHelper {

    private static final float[] SINE_TABLE = new float[65536];
    private static final double[] ARCSINE_TABLE = new double[257];
    private static final double[] COSINE_OF_ARCSINE_TABLE = new double[257];
    private static final double ROUNDER_256THS = Double.longBitsToDouble(4805340802404319232L);

    static {
        for (int i = 0; i < SINE_TABLE.length; i++) {
            SINE_TABLE[i] = (float) Math.sin(i * Math.PI * 2.0 / 65536.0);
        }
    }

    public static double nextTriangular(double mode, double deviation) {
        Random random = new Random();
        return mode + deviation * (random.nextDouble() - random.nextDouble());
    }

    public static float sin(float value) {
        return SINE_TABLE[(int) (value * 10430.378F) & 0xFFFF];
    }

    public static float cos(float value) {
        return SINE_TABLE[(int) (value * 10430.378F + 16384.0F) & 0xFFFF];
    }
}