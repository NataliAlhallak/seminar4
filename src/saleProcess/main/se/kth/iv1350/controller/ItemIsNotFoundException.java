package saleProcess.main.se.kth.iv1350.controller;

public class ItemIsNotFoundException extends Exception{

    public ItemIsNotFoundException(){
        super("The Item Is Not Found In store");
    }
}
