import java.io.*;
import java.util.*;


public class Main{

    static int videos[];
    static Endpoint endpoints[];
    static int numVideos, numEndPoint, reqDesc, numCaches, cacheSize;
    static String data[];
    static Scanner in;

    public static void main(String[] param){

        String zoo = "me_at_the_zoo.in";
        String kittens = "kittens.in";

        String filename = "../res/"+zoo;
        File inputFile = new File(filename);

        FileWriter fw = new FileWriter(filename);
        fw.write_line("Hello");
        fw.write_char(1);
        fw.write_char(2);
        fw.write_char(3);
        fw.write_char(4);
        fw.write_char(5);
        fw.write_charLn(6);
        try{
            in = new Scanner(inputFile);
        }
        catch(FileNotFoundException e){
            System.exit(1);
        }

        //number data
        data = in.nextLine().split(" ");

        numVideos = Integer.parseInt(data[0]);
        numEndPoint = Integer.parseInt(data[1]);
        reqDesc = Integer.parseInt(data[2]);
        numCaches = Integer.parseInt(data[3]);
        cacheSize = Integer.parseInt(data[4]);

        //data structures
        videos = new int[numVideos];
        endpoints = new Endpoint[numEndPoint];

        //video data
        data = in.nextLine().split(" "); //now videos

        setVideoInfo();
        setEndpoints();
        doRequests();

        in.close();
    }/*End main*/

    public static void doRequests(){

        //We start on the request data
        int endpointRequests, endpointID, videoID;

        while(in.hasNextLine()){
            data = in.nextLine().split(" ");
            // System.out.println(Arrays.toString(data));
            videoID = Integer.parseInt(data[0]);
            endpointID = Integer.parseInt(data[1]);
            endpointRequests = Integer.parseInt(data[2]);

            
        }
    }

    public static void setVideoInfo(){
        int videoSize = 0;
        for (int i = 0; i < numVideos; i++) {
            videoSize = Integer.parseInt(data[i]);
            videos[i] = videoSize;
        }
    }/*End setVideoInfo*/


    public static void setEndpoints(){

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
    }
}
