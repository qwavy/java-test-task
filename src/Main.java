import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            boolean minStats = Arrays.asList(args).contains("-s");
            boolean maxStats = Arrays.asList(args).contains("-f");
            int totalCount = 0;
            FileNames fileNames = new FileNames(args);

            FileWriter stringsWriter = new FileWriter(fileNames.getPath() + "strings.txt");
            FileWriter integersWriter = new FileWriter(fileNames.getPath() + "integers.txt");
            FileWriter floatsWriter = new FileWriter(fileNames.getPath() + "floats.txt");

            BufferedReader reader = new BufferedReader(new FileReader("filename.txt"));
            String line = reader.readLine();

            while (line != null) {
                if (minStats) {
                    totalCount++;
                }

                if (isNumber(line)) {
                    integersWriter.write(line + "\n");
                } else if (isFloat(line)) {
                    floatsWriter.write(line + "\n");
                } else {
                    stringsWriter.write(line + "\n");
                }
                line = reader.readLine();

            }

            integersWriter.close();
            floatsWriter.close();
            stringsWriter.close();
            reader.close();

            if (minStats) {
                System.out.println("total count " + totalCount);
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