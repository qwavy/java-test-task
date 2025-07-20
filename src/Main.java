import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{

            File strings = new File("strings.txt");
            File integers = new File("integers.txt");
            File floats = new File("floats.txt");
            FileWriter stringsWriter = new FileWriter("strings.txt");
            FileWriter integersWriter = new FileWriter("integers.txt");
            FileWriter floatsWriter = new FileWriter("floats.txt");

            for (int i = 0; i < args.length; i++) {
                if(args[i].equals("-p")) {
                    stringsWriter = new FileWriter(args[i+1] + "strings.txt");
                    integersWriter = new FileWriter(args[i+1] + "integers.txt");
                    floatsWriter = new FileWriter(args[i+1] + "floats.txt");
                }
            }

            BufferedReader reader = new BufferedReader(new FileReader("filename.txt"));
            String line = reader.readLine();

            while (line != null){
                if(isNumber(line)){
                    integersWriter.write(line + "\n");
                }else if(isFloat(line)){
                    floatsWriter.write(line + "\n");
                }else {
                    stringsWriter.write(line + "\n");
                }
                line = reader.readLine();
            }

            integersWriter.close();
            floatsWriter.close();
            stringsWriter.close();
            reader.close();
        } catch (IOException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static boolean isNumber(String arg) {
        try{
            Integer.parseInt(arg);
            return true;
        } catch (NumberFormatException e){
            return  false;
        }
    }
    public static boolean isFloat(String arg) {
        try{
            Float.parseFloat(arg);
            return true;
        } catch (NumberFormatException e){
            return  false;
        }
    }

}