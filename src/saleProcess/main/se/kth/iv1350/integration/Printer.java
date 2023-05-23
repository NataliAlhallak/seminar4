package saleProcess.main.se.kth.iv1350.integration;
import saleProcess.main.se.kth.iv1350.model.*;

    /**
    * The Printer class is responsible for printing receipts.
    */
public class Printer {
    /**
     * Creates an instance of Printer.
     */
    public Printer(){
    }

    /**
     * Prints the specified receipt.
     *
     * @param receipt The Receipt object that contains information about the finished sale.
     */
    public void PrintReceipt (Receipt receipt){
        System.out.println(receipt.creatReceiptString());
    }
}
