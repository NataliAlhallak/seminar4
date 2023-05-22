package saleProcess.tests.paymentTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import saleProcess.main.se.kth.iv1350.model.Payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentTest {

        private static Payment payment;
        private static double paymentAmount;

        @BeforeAll
        static void setUpBeforeClass(){
                payment =new Payment(paymentAmount);
        }

        @AfterAll
        static void tearDownAfterClass(){
                payment = null;
        }


        @BeforeEach
        void setUp() throws Exception {
        }

        @AfterEach
        void tearDown() throws Exception{
        }


        @Test
        void getChangeAmount() {
                double expectedChangeAmount = 250;
                double salePayment = 1400;
                payment.setAmountPaid(1650);
                double actualChangeAmount = payment.getChangeAmount(salePayment);
                assertEquals(expectedChangeAmount,actualChangeAmount, "The Calculation Is Not Correct");
        }

    }

