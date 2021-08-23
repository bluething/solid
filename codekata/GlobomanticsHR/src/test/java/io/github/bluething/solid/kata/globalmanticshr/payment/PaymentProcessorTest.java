package io.github.bluething.solid.kata.globalmanticshr.payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {
    @Test
    public void sendPaymentShouldPayAllEmployeeSalaries() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        int result = paymentProcessor.sendPayment();

        assertEquals(5440, result);
    }
}