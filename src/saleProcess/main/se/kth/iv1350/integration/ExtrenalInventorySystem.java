package saleProcess.main.se.kth.iv1350.integration;

import saleProcess.main.se.kth.iv1350.model.*;
public class ExtrenalInventorySystem {
    private PurchaseItems[] StoresInventory = new PurchaseItems[5];
    private PurchaseItems finalItem;



    /**
     *Creates an instance of ExternalInventorySystem.
     */
    public ExtrenalInventorySystem(){
    }

    /**
     * Method with the stores Items.
     * A list of items with items name, identifier, price and VAT rate.
     */
    private void storesItems(){
        StoresInventory[0] = new PurchaseItems(98762, new ItemDTO("Avocado", 22.0, 12.2));
        StoresInventory[1] = new PurchaseItems(98763, new ItemDTO("Milk", 33, 27.6));
        StoresInventory[2] = new PurchaseItems( 98764, new ItemDTO("Almond", 102, 33.3));
        StoresInventory[3] = new PurchaseItems( 98765, new ItemDTO("Apples", 43, 38.3));
        StoresInventory[4] = new PurchaseItems( 98768, new ItemDTO("Meat", 332, 99.9));
    }

    /**
     * Get the items Information if the items is in the list of stores items.
     * @param itemID is the items identifier and used to identify the item.
     * @return items information.
     */
    public PurchaseItems getItemInfo(int itemID) {
        storesItems();
        for (PurchaseItems item : StoresInventory) {
            if (item.getItemIdenitifier() == itemID) {
                finalItem = item;

                return finalItem;
            }
            else {
                finalItem = null;
            }
        }
        return finalItem;
    }


        /**
         * A method to update external inventory system.
         * @param Salinformation {@link SaleDTO} is an object that conatins informations about the sale.
         */
        public void updateExtrenalInventorySystem (SaleDTO Salinformation){

        }
    }