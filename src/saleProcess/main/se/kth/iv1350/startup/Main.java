package saleProcess.main.se.kth.iv1350.startup;

import saleProcess.main.se.kth.iv1350.controller.Controller;
import saleProcess.main.se.kth.iv1350.integration.ExternalAccountingSystem;
import saleProcess.main.se.kth.iv1350.integration.ExtrenalInventorySystem;
import saleProcess.main.se.kth.iv1350.integration.Printer;
import saleProcess.main.se.kth.iv1350.integration.RegisteryCreator;
import saleProcess.main.se.kth.iv1350.view.View;


public class Main {
    /**
     * The main method used to start the application.
     * @param args The application does not accept any command line parameters.
     */
    public static void main(String[] args) {
        ExternalAccountingSystem accountingSystem=new ExternalAccountingSystem();
        Printer printer = new Printer();
        RegisteryCreator regCreator = new RegisteryCreator();
        ExtrenalInventorySystem inventory = new ExtrenalInventorySystem();
        Controller contr = new Controller(regCreator,inventory ,printer,accountingSystem);
        new View(contr).sampleExecution();
    }
}
