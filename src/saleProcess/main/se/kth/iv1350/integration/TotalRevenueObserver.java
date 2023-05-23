package saleProcess.main.se.kth.iv1350.integration;

/**
 * The TotalRevenueObserver interface represents an observer of total revenue updates.
 * Classes implementing this interface can observe changes in total revenue.
 */

public interface TotalRevenueObserver {
    /**
     * This method is called when the total revenue is updated.
     *
     * @param totalAmountPayment The updated total revenue amount.
     */
    void updateTotalRevenue(double totalAmountPayment);
}
