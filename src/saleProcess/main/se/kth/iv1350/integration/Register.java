package saleProcess.main.se.kth.iv1350.integration;
import saleProcess.main.se.kth.iv1350.model.*;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private double storeAmount;
    private List<TotalRevenueObserver> paymentObservers = new ArrayList<>();


    /*
     *<code>Register</code> is a constructor of register
     */

    public Register() {
    }

    /**
     * Records the amount of payment.
     * @param amountPaid and the object {@link Payment} is the amount payment.
     */

    public void PaymentAmount (Payment amountPaid){
        this.storeAmount += amountPaid.getAmountPayment();
        notifyObserver();
    }

    /**
     * A method to get the stores amount.
     * @return stores amount of money.
     */

    private void notifyObserver() {
        for(TotalRevenueObserver observer : paymentObservers) {
            observer.updateTotalRevenue(storeAmount);
        }
    }
    public void addObserver(TotalRevenueObserver obs) {
        paymentObservers.add(obs);
    }


    public double getStoreAmount (){
        return storeAmount;
    }
}
