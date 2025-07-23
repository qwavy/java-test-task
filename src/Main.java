import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> inputFiles = Arrays.stream(args)
                    .filter(a -> a.endsWith(".txt"))
                    .collect(Collectors.toList());

            if(inputFiles.isEmpty()){
                System.out.println("no input files found");
            }

            boolean minStats = Arrays.asList(args).contains("-s");
            boolean maxStats = Arrays.asList(args).contains("-f");
            boolean appendToFile = Arrays.asList(args).contains("-a");

            List<String> stringStats = new ArrayList<>();
            List<Integer> integerStats = new ArrayList<>();
            List<Float> floatStats = new ArrayList<>();

            FileNames fileNames = new FileNames(args);

            FileWriter stringsWriter = null;
            FileWriter integersWriter = null;
            FileWriter floatsWriter = null;



            List<BufferedReader> readers = new ArrayList<>();
            for (String name : inputFiles) {
                readers.add(new BufferedReader(new FileReader(name)));
            }

            boolean anyLeft = true;
            while (anyLeft) {
                anyLeft = false;

                for (int i = 0; i < readers.size(); i++) {
                    BufferedReader br = readers.get(i);
                    if (br == null) continue;

                    String line = br.readLine();
                    if (line != null) {
                        anyLeft = true;
                        if (isNumber(line)) {
                            if(integersWriter == null){
                                integersWriter = new FileWriter(fileNames.getPath() + "integers.txt", appendToFile);
                            }
                            integersWriter.write(line + "\n");
                            integerStats.add(Integer.parseInt(line));
                        } else if (isFloat(line)) {
                            if(floatsWriter == null){
                                floatsWriter = new FileWriter(fileNames.getPath() + "floats.txt", appendToFile);
                            }
                            floatsWriter.write(line + "\n");
                            floatStats.add(Float.parseFloat(line));
                        } else {
                            if(stringsWriter == null){
                                stringsWriter = new FileWriter(fileNames.getPath() + "strings.txt", appendToFile);
                            }
                            stringsWriter.write(line + "\n");
                            stringStats.add(line);
                        }
                    } else {
                        br.close();
                        readers.set(i, null);
                    }
                }
            }

            if(integersWriter != null){
                integersWriter.close();
            }
            if(floatsWriter != null){
                floatsWriter.close();
            }
            if(stringsWriter != null){
                stringsWriter.close();
            }


            Stats stats = new Stats(stringStats, integerStats, floatStats, maxStats, minStats);
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