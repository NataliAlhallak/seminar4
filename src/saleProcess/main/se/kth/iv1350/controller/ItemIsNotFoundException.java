package saleProcess.main.se.kth.iv1350.controller;
/**
 * ItemIsNotFoundException is a custom exception class that represents
 * an exception when an item is not found in the store's inventory.
 * It extends the Exception class.
 */
public class ItemIsNotFoundException extends Exception{
    /**
     * Constructor for ItemIsNotFoundException.
     * Initializes the exception with a default error message.
     */

    public ItemIsNotFoundException(){
        super("The Item Is Not Found In store");
    }
}
