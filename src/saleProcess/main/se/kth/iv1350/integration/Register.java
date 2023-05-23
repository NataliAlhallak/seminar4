package saleProcess.main.se.kth.iv1350.integration;
import saleProcess.main.se.kth.iv1350.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 *The Register class is responsible for recording the amount of payment and keeping track of the store's amount of money.
 */
public class Register {
    private double storeAmount;
    private List<TotalRevenueObserver> paymentObservers = new ArrayList<>();

    /**
     * Creates an instance of Register.
     */
    public Register() {
    }

    /**
     * Records the amount of payment.
     * @param amountPaid The Payment object that represents the amount paid.
     */
    public void PaymentAmount (Payment amountPaid){
        this.storeAmount += amountPaid.getAmountPayment();
        notifyObserver();
    }


    /**
     * Notifies the registered observers about the updated total revenue.
     */

    private void notifyObserver() {
        for(TotalRevenueObserver observer : paymentObservers) {
            observer.updateTotalRevenue(storeAmount);
        }
    }

    /**
     * Adds an observer to the list of payment observers.
     *
     * @param obs The TotalRevenueObserver to be added.
     */

    public void addObserver(TotalRevenueObserver obs) {
        paymentObservers.add(obs);
    }

    /**
     * Returns the store's amount of money.
     *
     * @return The store's amount of money.
     */

    public double getStoreAmount (){
        return storeAmount;
    }
}
