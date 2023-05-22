package saleProcess.main.se.kth.iv1350.view;

import saleProcess.main.se.kth.iv1350.controller.*;
import saleProcess.main.se.kth.iv1350.utility.LogHandler;

public class View {
    private Controller contr;
    LogHandler logHandler;

    public View(Controller contr) {
        this.contr = contr;
        logHandler = new LogHandler();
    }

    public void sampleExecution()  {
        System.out.println("Welcome to the store");
        contr.startNewSale();
        int itemId = 98765;
        int quantity = 1;
        try {
            System.out.println("New Scanned Item" + contr.scanItems(itemId, quantity));


        } catch (InvalidItemIdentifierException error){
            System.out.println("This Item Identifier" + itemId + "Is Not Valid");

        } catch (DatabaseFailureException error){
            logHandler.logException(error);
            System.out.println("Database error : the item identifier could not be fetched");
        }

        contr.registerPayment(500);

        contr.endCurrentSale();
    }
}
