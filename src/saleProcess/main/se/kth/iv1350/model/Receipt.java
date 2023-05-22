package saleProcess.main.se.kth.iv1350.model;

import java.time.LocalDateTime;

public class Receipt {
    private SaleDTO currentSale;
    private StringBuilder salesItem;
    private Sale sale;

    /**
     * Creates a new instance.
     * 
     * @param sales and {@link SaleDTO} the contains the sal information.
     */
    public Receipt(SaleDTO sales, StringBuilder itemsList) {
        this.currentSale = sales;
        this.salesItem = itemsList;

    }

    private StringBuilder getItemsList() {
        salesItem = sale.itemsList();
        return salesItem;
    }

    private SaleDTO getCurrentSale() {
        return currentSale;
    }

    /*
     * The <code>creatReceiptString/<code> is to creat a string representation of
     * the receipt.
     * and @return a well-formatted receipt string.
     */

    public String creatReceiptString() {
        StringBuilder builder = new StringBuilder();
        appendLine(builder, "---------The Receipt-------");
        endSection(builder);

        LocalDateTime saleTime = LocalDateTime.now();
        builder.append("Sales Date and Timer: ");
        appendLine(builder, saleTime.toString());
        endSection(builder);

        builder.append("Purchased Items: " + salesItem);

        builder.append("total Price : " + currentSale.getTotalPrice() + "\n");
        builder.append("------------------------------------------------------ \n");
        builder.append("Amount Paid : " + currentSale.getPayment() + "\n");
        builder.append("Change : " + currentSale.getChange());

        endSection(builder);
        return builder.toString();
    }

    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }

    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }
}
