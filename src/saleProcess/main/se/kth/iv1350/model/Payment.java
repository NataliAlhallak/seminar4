package saleProcess.main.se.kth.iv1350.model;

public class Payment {
    private  double amountPaid;
    private double changeAmount;
    /**
     * Creates a new instance. The customer hands over the specific amount.
     *
     * @param amountPaid the amount left by the customer.
     */
    public Payment(double amountPaid) {
        this.amountPaid = amountPaid;
    }


    public double getChangeAmount(double salePayment ) {
        changeAmount = amountPaid - salePayment;
        return changeAmount ;
    }

    /**
     * Gets the amount payment.
     * @return the amount payment for the sale.
     */

    public double getAmountPayment(){
        return amountPaid;
    }

    public void setAmountPaid(double paymentAmount){
        this.amountPaid =paymentAmount;

    }
}


