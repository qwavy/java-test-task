import java.util.*;
import java.util.Collections;

public class Stats {
    public Stats(List<String> stringStats, List<Long> integerStats, List<Float> floatStats, boolean maxStats, boolean minStats) {
        if (maxStats) {
            getStringStats(stringStats);
            getIntegerStats(integerStats);
            getFloatStats(floatStats);
        } else {
            int totalCount = stringStats.size() + integerStats.size() + floatStats.size();
            System.out.println("strings count " + stringStats.size() + "\n" + "integers count " + integerStats.size() + "\n" + "floats count " + floatStats.size() + "\n" + "total count " + totalCount);
        }
    }

    public void getIntegerStats(List<Long> integerStats) {
        long max = Collections.max(integerStats);
        long min = Collections.min(integerStats);
        long sum = integerStats.stream().mapToLong(Long::longValue).sum();
        double avg = (double) sum / integerStats.size();

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
