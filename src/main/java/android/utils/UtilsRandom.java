package android.utils;

import static org.apache.commons.lang3.RandomUtils.nextInt;

public class UtilsRandom {
    public static Integer getRandomNaturalInteger(int maxValue) {
        return nextInt(1, maxValue);
    }
}
