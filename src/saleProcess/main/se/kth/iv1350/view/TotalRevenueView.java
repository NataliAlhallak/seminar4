package saleProcess.main.se.kth.iv1350.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import saleProcess.main.se.kth.iv1350.integration.TotalRevenueObserver;

public class TotalRevenueView implements TotalRevenueObserver {


    /**
     * Class TotalRevenueView implements the TotalRevenueObserver interface.
     * It displays the total revenue on the user interface.
     */


        /**
         * Creates a new TotalRevenueView instance.
         */
        public TotalRevenueView() {
        }

        @Override
        public void updateTotalRevenue(double totalSaleAmount) {
            System.out.println("The total revenue for all sales at " + getTime() + " is = " + totalSaleAmount + " SEK");
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

