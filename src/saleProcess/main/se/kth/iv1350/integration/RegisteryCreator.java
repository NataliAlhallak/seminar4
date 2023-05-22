package saleProcess.main.se.kth.iv1350.integration;

public class RegisteryCreator {
    private Register PaymentRegistry;

    /**
     *  Creates an instance to registery creator and identifies the payment register.
     *
     */
    public RegisteryCreator(){
        this.PaymentRegistry = new Register();
    }

    /**
     * A method to call the payment register.
     * @return payment registery.
     */
    public Register getPaymentRegister(){
        return PaymentRegistry;
    }
}
