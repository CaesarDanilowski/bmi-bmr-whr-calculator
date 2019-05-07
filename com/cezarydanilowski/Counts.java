package com.cezarydanilowski;

public class Counts {

    public static float countBMI(float weight, float height) {
        float bmi = weight / ((height / 100) * (height / 100));
        return bmi;
    }

    public static float countBMR(float weight, float height, int age, int a) {
        float bmr = (int) ((9.99 * weight) + (6.25 * height) - (4.92 * age) + a);
        return bmr;
    }

    public static float countWHR(float waist, float hips) {
        float whr = waist / hips;
        return whr;
    }
}
