package saleProcess.tests.externalInventorySystemTest;

import org.junit.jupiter.api.*;

import saleProcess.main.se.kth.iv1350.controller.DatabaseFailureException;
import saleProcess.main.se.kth.iv1350.controller.InvalidItemIdentifierException;
import saleProcess.main.se.kth.iv1350.controller.ItemIsNotFoundException;
import saleProcess.main.se.kth.iv1350.integration.ExtrenalInventorySystem;
import saleProcess.main.se.kth.iv1350.model.ItemDTO;
import saleProcess.main.se.kth.iv1350.model.PurchaseItems;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

class ExternalInventorySystemTest {
    private static ExtrenalInventorySystem inventorySystem;

    @BeforeAll
    static void setUpBeforeClass()throws Exception{
        inventorySystem = new ExtrenalInventorySystem();
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception{
        inventorySystem =null;
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getIValidItemInfo() throws DatabaseFailureException, InvalidItemIdentifierException {
        try {
            PurchaseItems expectedItem = new PurchaseItems(98765, new ItemDTO("Apples", 43, 38.3));
            PurchaseItems actualItem = inventorySystem.getItemInfo(98765);
            assertEquals(expectedItem, actualItem, "They are different Items");
                } catch (SQLException e) {
            throw new DatabaseFailureException();

        }catch (ItemIsNotFoundException e){

            throw new InvalidItemIdentifierException();
        }
    }

    @Test
    void getNoItems(){
        assertThrows(ItemIsNotFoundException.class, () -> {
            inventorySystem.getItemInfo(98767);
        }, "NO ITEM HAVE THIS identifier");
    }

    @Test
    void getDatabaseFailure(){
        assertThrows(SQLException.class, ()-> {
            inventorySystem.getItemInfo(98765);
        },"System error : failed to reach the database");
    }


}