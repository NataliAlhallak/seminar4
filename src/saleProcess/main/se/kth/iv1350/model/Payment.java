package saleProcess.main.se.kth.iv1350.model;

public class Payment {
    private  double amountPaid;
    private double changeAmount;

    /**
     * Creates a new instance of Payment. The customer hands over a specific amount.
     *
     * @param amountPaid The amount paid by the customer.
     */
    public Payment(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * Calculates and retrieves the change amount for the payment.
     *
     * @param salePayment The total payment amount for the sale.
     * @return The change amount to be returned to the customer.
     */

    public double getChangeAmount(double salePayment ) {
        changeAmount = amountPaid - salePayment;
        return changeAmount ;
    }

    /**
     * Gets the amount of payment.
     *
     * @return The amount of payment for the sale.
     */

    public double getAmountPayment(){
        return amountPaid;
    }

    /**
     * Sets the amount paid for the payment.
     *
     * @param paymentAmount The new amount paid for the payment.
     */

    public void setAmountPaid(double paymentAmount){
        this.amountPaid =paymentAmount;

    }
}


