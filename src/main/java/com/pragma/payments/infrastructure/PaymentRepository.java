package com.pragma.payments.infrastructure;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PaymentRepository {

    private final ConcurrentMap<String, String> payments = new ConcurrentHashMap<>();

    public void savePayment(String paymentId) {
        payments.put(paymentId, "Processed");
    }

    public String getPaymentStatus(String paymentId) {
        return payments.get(paymentId);
    }
}