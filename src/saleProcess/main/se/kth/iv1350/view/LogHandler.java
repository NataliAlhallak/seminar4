package saleProcess.main.se.kth.iv1350.view;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogHandler {
    public static final String LOG_FILE_Name = "error-log.txt";
    private PrintWriter logFile;

    public LogHandler() {
        try {
            logFile = new PrintWriter(new FileWriter(LOG_FILE_Name, true));
        }catch (IOException error){
            System.out.println("Error creating log file");
        }
    }

    public void logException (Exception exception){
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(", Exception Occurred during sale process: ");
        logMsgBuilder.append(exception.getMessage());
        logFile.println(logMsgBuilder);
        exception.printStackTrace(logFile);
    }

    private String createTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD  HH:mm:ss");
        Date now = new Date();
        return dateFormat.format(now);
    }

}
