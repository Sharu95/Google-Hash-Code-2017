import java.io.*;
import java.util.*;


public class Main{

    static int videos[];
    static Endpoint endpoints[];
    static int numVideos, 
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


        //data structures
        videos = new int[numVideos];
        endpoints = new Endpoint[numEndPoint];

        int videoSize = 0;
        for (int i = 0; i < numVideos; i++) {
            videoSize = Integer.parseInt(data[i]);
            videos[i] = videoSize;
        }

        setUpEndpoints();

        //first endpoint data
        int endpointID = 0;
        int latencyDC, connectedCashes;
        int cacheServerID = 0;
        int cacheServerLatency = 0;

        //We start on the N endpoint and set up all endoints
        while(endpointID < numEndPoint) {
            data = in.nextLine().split(" "); //get endpoint info

            latencyDC = Integer.parseInt(data[0]);
            connectedCashes = Integer.parseInt(data[1]);

            //make endpoint, add to structure, increase id
            Endpoint ep = new Endpoint(endpointID,latencyDC,numCaches); //on average level, we allocate to much using numCaches
            endpoints[endpointID] = ep;
            endpointID++;

            for (int i = 0; i < connectedCashes; i++) {
                data = in.nextLine().split(" "); //split next line to get cache ID and its latency
                cacheServerID = Integer.parseInt(data[0]);
                cacheServerLatency = Integer.parseInt(data[1]);
                ep.get_caches()[cacheServerID] = cacheServerLatency;
            }
        } /*End while*/

        //We start on the request data
        while(in.hasNextLine()){
            data = in.nextLine().split(" ");

        }
    }/*End main*/

    public static void setUpEndpoints(){

    }
}
