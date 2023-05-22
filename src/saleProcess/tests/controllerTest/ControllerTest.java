package saleProcess.tests.controllerTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import saleProcess.main.se.kth.iv1350.controller.Controller;
import saleProcess.main.se.kth.iv1350.integration.*;
import saleProcess.main.se.kth.iv1350.model.*;
public class ControllerTest {
        private static Controller contr;


        @BeforeAll
        static void setUpBeforeClass() {
            RegisteryCreator regCreator = new RegisteryCreator();
            ExternalAccountingSystem accountingSystem = new ExternalAccountingSystem();
            ExtrenalInventorySystem inventorySystem = new ExtrenalInventorySystem();
            Printer printer = new Printer();
            contr = new Controller (regCreator, inventorySystem, printer,accountingSystem);
        }

        @AfterAll
        static void tearDownAfterClass() {
            contr = null;
        }

        @BeforeEach
        void setUp() {
            contr.startNewSale();
        }

        @AfterEach
        void tearDown() {

        }

        @Test
        void testScanTheSameItems() {
            ItemDTO expectedItem = new ItemDTO("Milk", 33, 27.6);
            ItemDTO scannedItem = contr.scanItems(98763,1);
            assertEquals(expectedItem,scannedItem,"The items do not match");

        }

        @Test
        void testCheckItems() {
            int itemID = 12345;
            int itemQuantity = 1;
            ItemDTO checkItem = contr.scanItems(itemID,itemQuantity);
            assertNull(checkItem,"The Item with the ID" + itemID + "is not found");

        }

        @Test
        void testPayment() {
            contr.scanItems(98764,1);
            double expectedChangePayment = 98;
            double payment = 200;
            double actualChange = contr.registerPayment(payment);
            assertEquals(expectedChangePayment,actualChange,"The Payment is not registered");

        }
            }


