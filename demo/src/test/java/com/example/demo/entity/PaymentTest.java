package com.example.demo.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @Test
    public void whenNewPaymentReturnPayment() {
        Payment payment = new Payment(1L,"Ricardo", "TV", 300D,"USD");
        Assertions.assertEquals(1L,payment.getId());
        Assertions.assertEquals("Ricardo",payment.getPayer());
        Assertions.assertEquals("TV",payment.getPayee());
        Assertions.assertEquals(300D,payment.getAmount());
        Assertions.assertEquals("USD", payment.getCurrency());
    }
}
