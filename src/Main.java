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

        //number data
        String data[] = in.nextLine().split(" ");

        int numVideos = Integer.parseInt(data[0]);
        int numEndPoint = Integer.parseInt(data[1]);
        int reqDesc = Integer.parseInt(data[2]);
        int numCaches = Integer.parseInt(data[3]);
        int cacheSize = Integer.parseInt(data[4]);

        //video data
        data = in.nextLine().split(" "); //now videos


        //videos
        int videos[] = new int[numVideos];


        int videoSize = 0;
        for (int i = 0; i < numVideos; i++) {
            videoSize = Integer.parseInt(data[i]);
            videos[i] = videoSize;
        }

        // System.out.println(Arrays.toString(videos));

        //first endpoint data
        int endpoint = 0;
        data = in.nextLine().split(" ");


        System.out.println(Arrays.toString(data));
        // while(in.hasNextLine()) {
        // }




    }
}
