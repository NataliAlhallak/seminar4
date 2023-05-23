package saleProcess.main.se.kth.iv1350.integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TotalRevenueFileOutput implements TotalRevenueObserver {
    private PrintWriter file;
    private static final String LOG_FILE_NAME = "total-revenue-log.txt";

    public TotalRevenueFileOutput() {
        try {
            file = new PrintWriter(new FileWriter(LOG_FILE_NAME, true));
        } catch (IOException error) {
            System.out.println("An error occurred while creating the log file.");
        }
    }

    @Override
    public void updateTotalRevenue(double totalSaleAmount) {
        String logMsg = "Total revenue for all sales at " + getTime() + ": " + totalSaleAmount + " SEK";
        saveLogToFile(logMsg);
    }

    private void saveLogToFile(String logMsg) {
        file.println(logMsg);
        file.flush();
    }

    private String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();
        return formatter.format(now);
    }
}

