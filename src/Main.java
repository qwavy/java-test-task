//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File myObj = new File("filename.txt");
        try{
            myObj.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}