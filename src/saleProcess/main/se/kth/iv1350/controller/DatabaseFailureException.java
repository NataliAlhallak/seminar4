package saleProcess.main.se.kth.iv1350.controller;

/**
 * DatabaseFailureException is a custom exception class that represents
 * an exception when the database server fails to be connected.
 * It extends the Exception class.
 */

public class DatabaseFailureException extends Exception{
    /**
     * Constructs a new instance of ItemIsNotFoundException.
     * It sets the exception message to indicate that the item is not found in the store.
     */

    public DatabaseFailureException(){
        super("The Database server failed to be connected");
    }
}
