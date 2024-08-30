package com.example.demo.control.impl;


import com.example.demo.entity.Payment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IPaymentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.google.gson.Gson;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {PaymentService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
public class PaymentServiceTest {

    private Long ID = 1L;

    private Gson gson = new Gson();

    @MockBean
    private IPaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

    @Test
    void GivenIdWhenGetPaymentByIdThenReturnPayment() {
        Optional<Payment> optionalPayment =
                Optional.of(new Payment(ID,"Ricardo", "TV", 300D,"USD"));
        when(paymentRepository.findById(ID)).thenReturn(optionalPayment);
        Payment payment = paymentService.getPaymentById(ID).get();

        Assertions.assertEquals(gson.toJson(optionalPayment.get()), gson.toJson(payment));
    }

    @Test
    void testGetPaymentById2() {
        // Arrange
        Optional<Payment> optionalPayment = Optional.empty();
        when(paymentRepository.findById(Mockito.<Long>any())).thenReturn(optionalPayment);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> paymentService.getPaymentById(ID));
        verify(paymentRepository).findById(eq(ID));
    }


}
