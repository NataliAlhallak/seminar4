package saleProcess.main.se.kth.iv1350.controller;

public class InvalidItemIdentifierException extends Exception {
     public InvalidItemIdentifierException(){
            super("The Scanned Item Identifier In Not Valid");
        }
    }

