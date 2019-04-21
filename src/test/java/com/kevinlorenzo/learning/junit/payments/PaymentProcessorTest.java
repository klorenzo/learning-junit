package com.kevinlorenzo.learning.junit.payments;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

public class PaymentProcessorTest {

    @Test
    public void payment_is_correct() {

        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        Assert.assertTrue(paymentProcessor.makePayment(1000));

    }

    @Test
    public void payment_is_wrong() {

        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        Assert.assertFalse(paymentProcessor.makePayment(1000));

    }

}