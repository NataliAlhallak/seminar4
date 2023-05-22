package saleProcess.main.se.kth.iv1350.integration;
import saleProcess.main.se.kth.iv1350.model.*;
public class Register {
    private double storeAmount;


    /*
     *<code>Register</code> is a constructor of register
     */

    public Register() {
    }

    /**
     * Records the amount of payment.
     * @param payment and the object {@link Payment} is the amount payment.
     */

    public void PaymentAmount (Payment amountPaid){
        this.storeAmount += amountPaid.getAmountPayment();
    }

    /**
     * A method to get the stores amount.
     * @return stores amount of money.
     */
    public double getStoreAmount (){
        return storeAmount;
    }
}
