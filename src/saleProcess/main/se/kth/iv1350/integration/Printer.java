package saleProcess.main.se.kth.iv1350.integration;
import saleProcess.main.se.kth.iv1350.model.*;
public class Printer {
    public Printer(){
    }

    /*
     * the method prints the chosen receipt.
     *
     * @param receipt the {@link Receipt} is the object that contains info about the finished sale
     */
    public void PrintReceipt (Receipt receipt){
        System.out.println(receipt.creatReceiptString());
    }
}
