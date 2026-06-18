package com.pragma.pragma.payments.core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.pragma.payments.infrastructure.PaymentRepository;

public class PaymentProcessor {

    private final ExecutorService executorService;
    private final PaymentRepository paymentRepository;

    public PaymentProcessor(PaymentRepository paymentRepository) {
        this.executorService = Executors.newFixedThreadPool(10);
        this.paymentRepository = paymentRepository;
    }

    public CompletableFuture<String> processPayment(String paymentId) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate payment processing
            paymentRepository.savePayment(paymentId);
            return "Payment processed: " + paymentId;
        }, executorService);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}