package saleProcess.main.se.kth.iv1350.controller;

import saleProcess.main.se.kth.iv1350.model.*;
import saleProcess.main.se.kth.iv1350.integration.*;

import java.sql.SQLException;
 /**
  * This class is the main controller for the application.
  * It handles all requests that involve interacting with the model.
  * 
  * @author Shaemaa & Natali.
   */

public class Controller {
    private Sale sale;
    private Register paymentRegister;
    private ExtrenalInventorySystem inventorySystem;
    private Payment totalPayment;
    private Printer printReceipt;
    private ExternalAccountingSystem acctSystem;
    private SaleDTO saleInfo;
    /**
      * 
      * @param regCreator is object used to get the payment register.
      * @param inventory  is the external inventory system.
      * @param saleReceipt is the printer used to print sale receipts. 
      * @param accSystem  is the external accounting system. 
      */  

    public Controller(RegisteryCreator regCreator, ExtrenalInventorySystem inventory, Printer saleReceipt,
            ExternalAccountingSystem accSystem) {
        this.paymentRegister = regCreator.getPaymentRegister();
        this.inventorySystem = inventory;
        this.printReceipt = saleReceipt;
        this.acctSystem = accSystem;

    }
    /**It starts a new sale by creating a new Sale object. 
     * 
     * @return The new Sale object. 
     */

    public Sale startNewSale() {
        sale = new Sale();
        return sale;
    }
     /**
     * 
     * @param itemID is the identifier of the item. 
     * @param itemQuantity is the quantity of the item being scanned. 
     * @return the information of the item. 
     * @throws InvalidItemIdentifierException if the item is not found in the inventory system.
     */


    public ItemDTO scanItems(int itemID, int itemQuantity) throws InvalidItemIdentifierException, DatabaseFailureException {
        try {
            PurchaseItems checkItem = inventorySystem.getItemInfo(itemID);
            sale.registerItem(checkItem.getItemInfo(), itemQuantity);
            return checkItem.getItemInfo();
        } catch (ItemIsNotFoundException error) {
            throw new InvalidItemIdentifierException();
        } catch (SQLException error) {
            throw new DatabaseFailureException();
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
     * The payment method and amount are received.
     * @param amountPayment is the amount of payment which received from the customer. 
     * @return the calculated change to be given back to the customer.
     */

    public double registerPayment(double amountPayment) {

        totalPayment = new Payment(amountPayment);
        sale.updateInformation(totalPayment);
        sale.registerPayment(totalPayment);
        paymentRegister.PaymentAmount(totalPayment);
        sale.createReceipt(printReceipt);
        acctSystem.UpdateAccountingSystem(saleInfo);
        inventorySystem.updateExtrenalInventorySystem(saleInfo);
        double change = sale.getSaleInfo().getChange();
        return change;
    }
}
