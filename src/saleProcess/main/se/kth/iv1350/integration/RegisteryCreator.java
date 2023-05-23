package saleProcess.main.se.kth.iv1350.integration;

public class RegisteryCreator {
    private Register PaymentRegistry;

    /**
     * Creates an instance of RegisteryCreator and identifies the payment register.
     */
    public RegisteryCreator(){
        this.PaymentRegistry = new Register();
    }

    /**
     * Returns the payment register.
     *
     * @return The payment register.
     */

    public Register getPaymentRegister(){
        return PaymentRegistry;
    }
}
