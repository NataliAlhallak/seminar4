package saleProcess.main.se.kth.iv1350.controller;

import saleProcess.main.se.kth.iv1350.model.*;
import saleProcess.main.se.kth.iv1350.integration.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the main controller for the application.
 * It handles all requests that involve interacting with the model.
 *
 */

public class Controller {
    private Sale sale;
    private Register paymentRegister;
    private ExtrenalInventorySystem inventorySystem;
    private Payment totalPayment;
    private Printer printReceipt;
    private ExternalAccountingSystem acctSystem;
    private SaleDTO saleInfo;
    private List<TotalRevenueObserver> paymentObservers = new ArrayList<>();

    /**
     * Creates a new Controller instance.
     *
     * @param regCreator  The object used to get the payment register.
     * @param inventory   The external inventory system.
     * @param saleReceipt The printer used to print sale receipts.
     * @param accSystem   The external accounting system.
     */
    public Controller(RegisteryCreator regCreator, ExtrenalInventorySystem inventory, Printer saleReceipt,
            ExternalAccountingSystem accSystem) {
        this.paymentRegister = regCreator.getPaymentRegister();
        this.inventorySystem = inventory;
        this.printReceipt = saleReceipt;
        this.acctSystem = accSystem;

    }

    /**
     * Starts a new sale by creating a new Sale object.
     *
     * @return The new Sale object.
     */

    public Sale startNewSale() {
        sale = new Sale();
        return sale;
    }

    /**
     * Scans an item with the provided identifier and quantity.
     *
     * @param itemID       The identifier of the item.
     * @param itemQuantity The quantity of the item being scanned.
     * @return The information of the scanned item.
     * @throws InvalidItemIdentifierException If the item is not found in the inventory system.
     * @throws DatabaseFailureException      If there is a failure in the database.
     */
    public ItemDTO scanItems(int itemID, int itemQuantity) throws InvalidItemIdentifierException, DatabaseFailureException {
        try {
            PurchaseItems checkItem = inventorySystem.getItemInfo(itemID);
            sale.registerItem(checkItem.getItemInfo(), itemQuantity);
            return checkItem.getItemInfo();

        } catch (SQLException error) {
            throw new DatabaseFailureException();

        } catch (ItemIsNotFoundException error) {
            throw new InvalidItemIdentifierException();
        }
    }

    /**
     * Ends the current sale by resetting related objects and variables.
     */


    public void endCurrentSale() {
        this.sale = null;
        this.totalPayment = null;
        this.saleInfo = null;
    }

    /**
     * Registers a TotalRevenueObserver to observe total revenue updates.
     *
     * @param obs The TotalRevenueObserver to add.
     */
    public void addObserver(TotalRevenueObserver obs){
        paymentObservers.add(obs);
    }

    /**
     * Registers the payment amount and performs necessary operations related to the sale.
     *
     * @param amountPayment The amount of payment received from the customer.
     * @return The calculated change to be given back to the customer.
     */
    public double registerPayment(double amountPayment) {

        totalPayment = new Payment(amountPayment);
        sale.updateInformation(totalPayment);
        acctSystem.UpdateAccountingSystem(saleInfo);
        inventorySystem.updateExternalInventorySystem(saleInfo);
        double change = sale.getSaleInfo().getChange();

        for(TotalRevenueObserver observer : paymentObservers) {
            paymentRegister.addObserver(observer);
        }

        sale.registerPayment(totalPayment);
        paymentRegister.PaymentAmount(totalPayment);
        sale.createReceipt(printReceipt);
        return change;
    }
}
