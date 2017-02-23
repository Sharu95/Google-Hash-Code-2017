import java.io.*;

class FileWriter{
    private String logFileName="";
    private String logLine="";
    private int nLogLines=0;

    public FileWriter(String filename){
        logFileName = filename.substring(0, filename.length() - 3) + ".log";
        System.out.println(logFileName);
        File f = new File(logFileName);
    }

    public void write_line(String data){
        try {
    	    PrintWriter log = (nLogLines==0 ? new PrintWriter(logFileName) :
    		new PrintWriter(new FileOutputStream(logFileName,true)));

    	    log.println(data);  ++nLogLines;
    	    log.close();
    	} catch (FileNotFoundException e) {
            System.out.println("Cant find the good damn file!");
    	}
    }

    public void write_char(int data){
        if(logLine.length() > 0)
            logLine = logLine + " " + data;
        else
            logLine = ""+data;
    }

    public void write_charLn(int data){
        write_char(data);
        write_line(logLine);
        logLine = "";
    }
}
