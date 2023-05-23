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
        System.out.println("Total revenue for all sales: " + totalSaleAmount + " SEK");
    }
}

