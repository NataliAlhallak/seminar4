package saleProcess.main.se.kth.iv1350.model;

public class SaleDTO {

    private final double totalPrice;
    private final double totalVAT;
    private final String timeOfSale;
    private final double amountPayment;
    private final double change;

    /**
     * AN instance for the SaleDTO which contains information about the Sale.
     * 
     * @param totPrice is the total price of the purchased items.
     * @param totalVAT the total VAT rate for all the items.
     * @param saleDate is the date of the sale.
     */

    public SaleDTO(double totPrice, double totalVAT, String saleDate, double amountPayment, double change) {
        this.totalPrice = totPrice;
        this.totalVAT = totalVAT;
        this.timeOfSale = saleDate;
        this.amountPayment = amountPayment;
        this.change = change;

    }

    public double getPayment() {
        return this.amountPayment;
    }

    public double getChange() {
        return this.change;
    }

    /**
     * Gets the total price of the sale.
     * 
     * @return the total price.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * gets the total VAT rate.
     * 
     * @return the total VAT rate.
     */

    public double getTotalVAT() {
        return totalVAT;
    }

    /**
     * Gets the local date and time of the sale.
     * 
     * @return the time and the date of the sale.
     */

    public String getDateAndTime() {
        return timeOfSale;
    }
}
