package saleProcess.main.se.kth.iv1350.controller;

public class DatabaseFailureException extends Exception{

    public DatabaseFailureException(){
        super("The Database server failed to be connected");
    }
}
