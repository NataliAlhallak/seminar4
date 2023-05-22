package saleProcess.main.se.kth.iv1350.controller;
/**
 * InvalidItemIdentifierException is a custom exception class that represents
 * an exception when the scanned item identifier is not valid.
 */

public class InvalidItemIdentifierException extends Exception {
    /**
     * Constructor for InvalidItemIdentifierException.
     * Initializes the exception with a default error message.
     */
     public InvalidItemIdentifierException(){
            super("The Scanned Item Identifier In Not Valid");
        }
    }

