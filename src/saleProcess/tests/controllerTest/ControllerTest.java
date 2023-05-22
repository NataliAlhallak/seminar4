package saleProcess.tests.controllerTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import saleProcess.main.se.kth.iv1350.controller.Controller;
import saleProcess.main.se.kth.iv1350.controller.DatabaseFailureException;
import saleProcess.main.se.kth.iv1350.controller.InvalidItemIdentifierException;
import saleProcess.main.se.kth.iv1350.integration.*;
import saleProcess.main.se.kth.iv1350.model.*;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
        private static Controller contr;


        @BeforeAll
        static void setUpBeforeClass() throws Exception {
            RegisteryCreator regCreator = new RegisteryCreator();
            ExternalAccountingSystem accountingSystem = new ExternalAccountingSystem();
            ExtrenalInventorySystem inventorySystem = new ExtrenalInventorySystem();
            Printer printer = new Printer();
            contr = new Controller (regCreator, inventorySystem, printer,accountingSystem);
        }

        @AfterAll
        static void tearDownAfterClass() throws Exception{
            contr = null;
        }

        @BeforeEach
        void setUp() throws Exception {
            contr.startNewSale();
        }

        @AfterEach
        void tearDown() throws Exception{

        }

        @Test
        void testScanTheSameItems() {
            try{

            ItemDTO expectedItem = new ItemDTO("Milk", 33, 27.6);
            ItemDTO scannedItem = contr.scanItems(98763,1);

            assertEquals(expectedItem,scannedItem,"The items do not match");

            } catch (InvalidItemIdentifierException | DatabaseFailureException error){
                fail("unexpected exception occurred" + error.getMessage());
            }
        }

        @Test
        void testCheckItems() {
            int itemID = 12345;
            int itemQuantity = 1;
            assertThrows(InvalidItemIdentifierException.class, () -> {
                contr.scanItems(itemID,itemQuantity);
            });
        }

      @Test
        void testPayment() throws InvalidItemIdentifierException, DatabaseFailureException {
            try {
                contr.scanItems(98764,1);
            }catch (InvalidItemIdentifierException | DatabaseFailureException error){
                fail("An Exception occurred"+ error.getMessage());
            }
            double expectedChangePayment = 98;
            double payment = 200;
            double actualChange = contr.registerPayment(payment);
            assertEquals(expectedChangePayment,actualChange,"The Payment is not registered");

        }
}


