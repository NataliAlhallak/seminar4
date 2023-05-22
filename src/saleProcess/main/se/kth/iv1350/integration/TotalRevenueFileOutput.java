package saleProcess.main.se.kth.iv1350.integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TotalRevenueFileOutput implements TotalRevenueObserver{
    private PrintWriter logFile;
    private static final String LOG_FILE_NAME = "observer-log.txt";
    private StringBuilder logMsgBuilder = new StringBuilder();

    /**
     * Initializes the TotalRevenueFileOutput and creates the log file.
     */
    public TotalRevenueFileOutput() {
        try {
            logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME, true));
        } catch (IOException error) {
            System.out.println("Could not create file log");
        }
    }

    @Override
    public void updateTotalRevenue(double totalSaleAmount) {
        logMsgBuilder.setLength(0);
        logMsgBuilder.append("The total revenue for all sales at " + getTime() + " is = " + totalSaleAmount + " SEK");
        logFile.println(logMsgBuilder.toString());
        logFile.flush();
    }

    /**
     * Returns the current time and date in the specified format.
     *
     * @return The formatted time and date.
     */
    private String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();
        return dateFormat.format(now);
    }


}
