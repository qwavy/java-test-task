import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("filename.txt"));
            String line = reader.readLine();

            while (line != null){
                if(isNumber(line)){
                    System.out.println("number " + line);
                }else if(isFloat(line)){
                    System.out.println("float " + line);
                }else {
                    System.out.println(line);
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e){
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