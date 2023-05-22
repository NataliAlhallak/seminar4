package saleProcess.main.se.kth.iv1350.view;

import saleProcess.main.se.kth.iv1350.controller.*;

public class View {
    private Controller contr;

    public View(Controller contr) {
        this.contr = contr;
    }

    public void sampleExecution()  {
        System.out.println("Welcome to the store");
        contr.startNewSale();
        int itemId = 98762;
        int quantity = 6;
        try {
            System.out.println("New Scanned Item" + contr.scanItems(itemId, quantity));
            System.out.println("New Scanned Item" + contr.scanItems(98763, 1));
            contr.registerPayment(500);

        } catch (InvalidItemIdentifierException error){
            System.out.println("This Item Identifier" +itemId + "Is Not Valid");

        } catch (DatabaseFailureException error){
            
        }

        contr.endCurrentSale();
    }
}
