package com.kevinlorenzo.learning.junit.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest paymentRequest);

}