package saleProcess.main.se.kth.iv1350.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import saleProcess.main.se.kth.iv1350.integration.*;

public class Sale {
    private List<Item> items = new ArrayList<Item>();
    private double totalPrice;
    private double totalVAT;
    private String saleDate;
    private SaleDTO saleInfo;
    private Receipt receipt;
    private double runningTotal;
    private  double change;

    /**
     * Creat a new instance of sale.
     */
    public Sale() {

        setTimeOfSale();
    }

    /**
     * A method the register items of the current sale.
     * if the item exist in the inventory then it registers into the list of items.
     * 
     * @param item         is the items information
     * @param itemQuantity is the quantity value of the item.
     */
    public void registerItem(ItemDTO item, int itemQuantity) {
        if (!(checkIfItemExist(item, itemQuantity))) {
            items.add(new Item(item, itemQuantity));
        }
    }

    /**
     *
     * @param item
     * @param itemQuantity
     * @return
     */
    private boolean checkIfItemExist(ItemDTO item, int itemQuantity) {

        boolean result = false;
        for (Item itemInSale : items) {
            if (item.getItemsName().equals(itemInSale.getItems().getItemsName())) {
                {
                    result = true;
                    itemInSale.increaseItemQuantity(itemQuantity);
                    break;
                }

            }

        }
        return result;
    }

    public StringBuilder itemsList() {
        StringBuilder finalItems = new StringBuilder();
        List<Item> listOfItems = items;
        for (int i = 0; i < items.size(); i++) {
            String itemsName = listOfItems.get(i).getItems().getItemsName();
            double itemPrice = listOfItems.get(i).getItems().getItemPrice();
            int itemQuantity = listOfItems.get(i).getItemQuantity();
            runningTotal = itemPrice * itemQuantity;
            finalItems.append(
                    String.format("%-20s %-10d %10.2f %10.2f%n", itemsName, itemQuantity, itemPrice, runningTotal));
        }
        return finalItems;
    }





    private void getTotVat() {

        for (int i = 0; i < items.size(); i++) {
            this.totalVAT += items.get(i).getItems().getVATRate() * items.get(i).getItemQuantity();
        }
    }

    private void setTimeOfSale() {
        Date date = new Date();
        SimpleDateFormat Dateofsale = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.saleDate = Dateofsale.format(date);
    }
    public void registerPayment(Payment amountPayment) {
        Register register = new Register();
        register.PaymentAmount(amountPayment);
    }

    private double calculateTotalPrice() {
        runningTotal = 0;
        for (int i = 0; i < items.size(); i++) {
            runningTotal += items.get(i).getItems().getItemPrice() * items.get(i).getItemQuantity();
        }
        getTotVat();
        return runningTotal;
    }
    public void getTotalSaleAmount(Payment payment) {
        this.totalPrice = runningTotal;
        this.change = payment.getChangeAmount(runningTotal);
    }

    public void updateInformation(Payment amountPayment) {
    calculateTotalPrice();
    getTotalSaleAmount(amountPayment);

        this.saleInfo = new SaleDTO(totalPrice, totalVAT, saleDate, runningTotal, change);
    }

    public SaleDTO getSaleInfo() {
        return this.saleInfo;
    }

    /**
     * @param printer
     * @return
     */
    public Receipt createReceipt(Printer printer) {
        receipt = new Receipt(saleInfo, itemsList());
        printer.PrintReceipt(receipt);
        return receipt;

    }

}
