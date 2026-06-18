package com.pragma.payments;

import com.pragma.payments.core.PaymentProcessor;
import com.pragma.payments.infrastructure.PaymentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentProcessorTest {

    private PaymentProcessor paymentProcessor;
    private PaymentRepository paymentRepository;

    @BeforeEach
    public void setUp() {
        paymentRepository = new PaymentRepository();
        paymentProcessor = new PaymentProcessor(paymentRepository);
    }

    @AfterEach
    public void tearDown() {
        paymentProcessor.shutdown();
    }

    @Test
    public void testProcessPayment() throws Exception {
        String paymentId = "123";
        CompletableFuture<String> future = paymentProcessor.processPayment(paymentId);
        assertEquals("Payment processed: 123", future.get());
    }
}