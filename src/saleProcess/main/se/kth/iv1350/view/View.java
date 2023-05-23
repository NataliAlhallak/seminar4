package saleProcess.main.se.kth.iv1350.view;

import saleProcess.main.se.kth.iv1350.controller.*;
import saleProcess.main.se.kth.iv1350.integration.TotalRevenueFileOutput;
import saleProcess.main.se.kth.iv1350.utility.LogHandler;

/**
 * The View class represents the user interface for the point of sale system.
 * It interacts with the Controller to facilitate sale processes and display information to the user.
 */
public class View {
    private Controller contr;
    LogHandler logHandler;

    /**
     * Creates a new instance of the View class.
     *
     * @param contr The Controller instance to interact with.
     */
    public View(Controller contr) {
        this.contr = contr;
        contr.addObserver(new TotalRevenueView());
        contr.addObserver(new TotalRevenueFileOutput());
        logHandler = new LogHandler();
    }

    /**
     * Executes a sample sale process.
     * It demonstrates the flow of the sale process and handles exceptions.
     */

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
