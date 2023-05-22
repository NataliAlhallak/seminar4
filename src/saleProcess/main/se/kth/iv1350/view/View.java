package saleProcess.main.se.kth.iv1350.view;

import saleProcess.main.se.kth.iv1350.controller.*;
import saleProcess.main.se.kth.iv1350.integration.TotalRevenueFileOutput;
import saleProcess.main.se.kth.iv1350.utility.LogHandler;

public class View {
    private Controller contr;

    LogHandler logHandler;

    public View(Controller contr) {
        this.contr = contr;
        contr.addObserver(new TotalRevenueView());
        contr.addObserver(new TotalRevenueFileOutput());
        logHandler = new LogHandler();
    }

    public void sampleExecution() {
        System.out.println("Welcome to the store");
        contr.startNewSale();

        int itemID = 0;
        try {
            itemID = 98765;
            System.out.println("New Scanned Item" + contr.scanItems(itemID, 1));

        } catch (InvalidItemIdentifierException error) {
            System.out.println("This Item Identifier " + itemID + " Is Not Valid");

        } catch (DatabaseFailureException error) {
            logHandler.logException(error);
            System.out.println("Database error : the item identifier could not be fetched");
        }
        try {
            itemID = 98762;
            System.out.println("New Scanned Item" + contr.scanItems(itemID, 6));

        } catch (InvalidItemIdentifierException error) {
            System.out.println("This Item Identifier" + itemID + "Is Not Valid");

        } catch (DatabaseFailureException error) {
            logHandler.logException(error);
            System.out.println("Database error : the item identifier could not be fetched");
        }

        try {
            itemID = 98764;
            System.out.println("New Scanned Item" + contr.scanItems(itemID, 2));

        } catch (InvalidItemIdentifierException error) {
            System.out.println("This Item Identifier" + itemID + "Is Not Valid");

        } catch (DatabaseFailureException error) {
            logHandler.logException(error);
            System.out.println("Database error : the item identifier could not be fetched");
        }

        try {
            itemID = 123456;
            System.out.println("New Scanned Item" + contr.scanItems(itemID, 1));

        } catch (InvalidItemIdentifierException error) {
            System.out.println("This Item Identifier " + itemID + " Is Not Valid");

        } catch (DatabaseFailureException error) {
            logHandler.logException(error);
            System.out.println("Database error : the item identifier could not be fetched");
        }

        contr.registerPayment(500);

        contr.endCurrentSale();
    }
}
