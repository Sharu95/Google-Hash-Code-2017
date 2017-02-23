import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] param){
        String zoo = "me_at_the_zoo.in";
        String kittens = "kittens.in";

        String filename = "../res/"+zoo;
        File inputFile = new File(filename);
        Scanner in = null;

        try{
            in = new Scanner(inputFile);
        }
        catch(FileNotFoundException e){
            System.exit(1);
        }

        String numbers = in.readNextLine();
        System.out.println(numbers);

        // while(in.hasNextLine()){
        //     //do something
        // }




    }
}
