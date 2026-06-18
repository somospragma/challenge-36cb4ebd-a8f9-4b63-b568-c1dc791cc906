package com.pragma.payments.application;

import com.pragma.payments.core.PaymentProcessor;

public class PaymentService {

    private final PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public CompletableFuture<String> processPayment(String paymentId) {
        return paymentProcessor.processPayment(paymentId);
    }
}