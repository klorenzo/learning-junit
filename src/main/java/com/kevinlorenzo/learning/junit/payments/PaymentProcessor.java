package com.kevinlorenzo.learning.junit.payments;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {
        PaymentResponse paymentResponse = paymentGateway.requestPayment(new PaymentRequest(amount));

        if(paymentResponse.getPaymentStatus() == PaymentResponse.PaymentStatus.OK) {
            return true;
        }

        return false;
    }

}