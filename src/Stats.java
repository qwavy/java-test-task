import java.util.*;
import java.util.Collections;

public class Stats {
    public Stats(List<String> stringStats, List<Integer> integerStats, List<Float> floatStats, boolean maxStats) {
        if (maxStats) {
            getStringStats(stringStats);
            getIntegerStats(integerStats);
            getFloatStats(floatStats);
        }
    }

    public void getIntegerStats(List<Integer> integerStats) {
        int max = Collections.max(integerStats);
        int min = Collections.min(integerStats);
        int sum = integerStats.stream().mapToInt(Integer::intValue).sum();
        int avg = sum / integerStats.size();

        System.out.print("full stats for integers " + "maximum " + max + " minimum " + min + " sum " + sum + " avg " + avg + "\n");
    }


    public void getFloatStats(List<Float> floatStats) {
        float max = Collections.max(floatStats);
        float min = Collections.min(floatStats);
        float sum = 0;
        for (int i = 0; i < floatStats.size(); i++) {
            sum += floatStats.get(i);
        }
        float avg = sum / floatStats.size();

        System.out.print("full stats for floats " + "maximum " + max + " minimum " + min + " sum " + sum + " avg " + avg + "\n");
    }

    public void getStringStats(List<String> stringStats) {
        int length = stringStats.size();
        int maxLength = 0;
        int minLength = 0;

        for (int i = 0; i < length; i++) {
            maxLength = Math.max(maxLength, stringStats.get(i).length());
            minLength = Math.min(maxLength, stringStats.get(i).length());
        }

        System.out.print("full stats for strings " + "maximum " + maxLength + " minimum " + minLength + " length " + length + "\n");
    }
}
