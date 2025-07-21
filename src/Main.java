import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            boolean minStats = Arrays.asList(args).contains("-s");
            boolean maxStats = Arrays.asList(args).contains("-f");

            List<String> stringStats = new ArrayList<>();
            List<Integer> integerStats = new ArrayList<>();
            List<Float> floatStats = new ArrayList<>();

            FileNames fileNames = new FileNames(args);

            FileWriter stringsWriter = new FileWriter(fileNames.getPath() + "strings.txt");
            FileWriter integersWriter = new FileWriter(fileNames.getPath() + "integers.txt");
            FileWriter floatsWriter = new FileWriter(fileNames.getPath() + "floats.txt");

            BufferedReader reader = new BufferedReader(new FileReader("filename.txt"));
            String line = reader.readLine();

            while (line != null) {


                if (isNumber(line)) {
                    integersWriter.write(line + "\n");
                    integerStats.add(Integer.parseInt(line));
                } else if (isFloat(line)) {
                    floatsWriter.write(line + "\n");
                    floatStats.add(Float.parseFloat(line));
                } else {
                    stringsWriter.write(line + "\n");
                    stringStats.add(line);
                }
                line = reader.readLine();

            }

            integersWriter.close();
            floatsWriter.close();
            stringsWriter.close();
            reader.close();

            if(maxStats) {
                Stats stats = new Stats(stringStats, integerStats, floatStats, maxStats);
//                stats.getStats();
            }
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static boolean isNumber(String arg) {
        try {
            Integer.parseInt(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isFloat(String arg) {
        try {
            Float.parseFloat(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}