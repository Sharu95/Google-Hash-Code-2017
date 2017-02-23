import java.io.*;

class FileWriter{
    private String logFileName="";
    private int nLogLines=0;

    public Filewriter(String filename){
        this.logFileName = filename.substring(0, filename.length - 2) + ".log";
    }

    public void write_line(String data){
        try {
    	    PrintWriter log = (nLogLines==0 ? new PrintWriter(logFileName) :
    		new PrintWriter(new FileOutputStream(logFileName,true)));

    	    log.println(data);  ++nLogLines;
    	    log.close();
    	} catch (FileNotFoundException e) {
    	    String lName = logFileName;
    	    logFileName = null;

    	    Main.error("Cannot open log file " + lName + "!");
    	}
    }
}
