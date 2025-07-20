import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            String prefix = "";
            String dirName = "";
            String path = "";

            for (int i = 0; i < args.length; i++) {
                if(args[i].equals("-p")) {
                    prefix = args[i+1];
                } else if(args[i].equals("-o")) {
                    dirName = args[i+1];
                    File dir = new File(dirName);
                    if(!dir.exists()){
                        dir.mkdir();
                    }
                }
            }

            if(dirName != ""){
                path = dirName + "/";
            }
            if(prefix != ""){
                path += prefix + "_";
            }

            FileWriter stringsWriter = new FileWriter(path+ "strings.txt");
            FileWriter integersWriter = new FileWriter(path + "integers.txt");
            FileWriter floatsWriter = new FileWriter(path + "floats.txt");

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