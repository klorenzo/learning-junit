package com.kevinlorenzo.learning.junit.payments;

public class PaymentResponse {

    public enum PaymentStatus {
        OK, ERROR
    }

    private PaymentStatus paymentStatus;

    public PaymentResponse(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

}