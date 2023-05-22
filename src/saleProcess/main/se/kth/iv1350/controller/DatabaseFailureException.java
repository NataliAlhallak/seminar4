package saleProcess.main.se.kth.iv1350.controller;

public class DatabaseFailureException extends Exception{

    public DatabaseFailureException(String msg,Exception cause ){
        super(msg, cause);
    }
}
