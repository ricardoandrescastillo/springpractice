package com.example.demo.control.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.entity.Payment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IPaymentRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PaymentService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PaymentServiceDiffblueTest {
    @MockBean
    private IPaymentRepository iPaymentRepository;

    @Autowired
    private PaymentService paymentService;

    /**
     * Method under test: {@link PaymentService#getPaymentById(Long)}
     */
    @Test
    void testGetPaymentById() {
        // Arrange
        Optional<Payment> ofResult = Optional.of(new Payment());
        when(iPaymentRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Optional<Payment> actualPaymentById = paymentService.getPaymentById(1L);

        // Assert
        verify(iPaymentRepository).findById(eq(1L));
        assertEquals(ofResult, actualPaymentById);
    }

    /**
     * Method under test: {@link PaymentService#getPaymentById(Long)}
     */
    @Test
    void testGetPaymentById2() {
        // Arrange
        Optional<Payment> emptyResult = Optional.empty();
        when(iPaymentRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> paymentService.getPaymentById(1L));
        verify(iPaymentRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link PaymentService#getPaymentById(Long)}
     */
    @Test
    void testGetPaymentById3() {
        // Arrange
        when(iPaymentRepository.findById(Mockito.<Long>any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> paymentService.getPaymentById(1L));
        verify(iPaymentRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link PaymentService#getAllPayments()}
     */
    @Test
    void testGetAllPayments() {
        // Arrange
        ArrayList<Payment> paymentList = new ArrayList<>();
        when(iPaymentRepository.findAll()).thenReturn(paymentList);

        // Act
        List<Payment> actualAllPayments = paymentService.getAllPayments();

        // Assert
        verify(iPaymentRepository).findAll();
        assertTrue(actualAllPayments.isEmpty());
        assertSame(paymentList, actualAllPayments);
    }

    /**
     * Method under test: {@link PaymentService#getAllPayments()}
     */
    @Test
    void testGetAllPayments2() {
        // Arrange
        when(iPaymentRepository.findAll()).thenThrow(new ResourceNotFoundException("An error occurred"));

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> paymentService.getAllPayments());
        verify(iPaymentRepository).findAll();
    }

    /**
     * Method under test: {@link PaymentService#createPayment(Payment)}
     */
    @Test
    void testCreatePayment() {
        // Arrange
        Payment payment = new Payment();
        when(iPaymentRepository.save(Mockito.<Payment>any())).thenReturn(payment);

        // Act
        Payment actualCreatePaymentResult = paymentService.createPayment(new Payment());

        // Assert
        verify(iPaymentRepository).save(isA(Payment.class));
        assertSame(payment, actualCreatePaymentResult);
    }

    /**
     * Method under test: {@link PaymentService#createPayment(Payment)}
     */
    @Test
    void testCreatePayment2() {
        // Arrange
        when(iPaymentRepository.save(Mockito.<Payment>any())).thenThrow(new ResourceNotFoundException("An error occurred"));

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> paymentService.createPayment(new Payment()));
        verify(iPaymentRepository).save(isA(Payment.class));
    }

    /**
     * Method under test: {@link PaymentService#updatePayment(Long, Payment)}
     */
    @Test
    void testUpdatePayment() {
        // Arrange
        Payment payment = new Payment();
        when(iPaymentRepository.save(Mockito.<Payment>any())).thenReturn(payment);
        Optional<Payment> ofResult = Optional.of(new Payment());
        when(iPaymentRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Payment actualUpdatePaymentResult = paymentService.updatePayment(1L, new Payment());

        // Assert
        verify(iPaymentRepository).findById(eq(1L));
        verify(iPaymentRepository).save(isA(Payment.class));
        assertSame(payment, actualUpdatePaymentResult);
    }

    /**
     * Method under test: {@link PaymentService#updatePayment(Long, Payment)}
     */
    @Test
    void testUpdatePayment2() {
        // Arrange
        when(iPaymentRepository.save(Mockito.<Payment>any())).thenThrow(new ResourceNotFoundException("An error occurred"));
        Optional<Payment> ofResult = Optional.of(new Payment());
        when(iPaymentRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> paymentService.updatePayment(1L, new Payment()));
        verify(iPaymentRepository).findById(eq(1L));
        verify(iPaymentRepository).save(isA(Payment.class));
    }

    /**
     * Method under test: {@link PaymentService#updatePayment(Long, Payment)}
     */
    @Test
    void testUpdatePayment3() {
        // Arrange
        Payment payment = mock(Payment.class);
        when(payment.getId()).thenThrow(new ResourceNotFoundException("An error occurred"));
        Optional<Payment> ofResult = Optional.of(payment);
        when(iPaymentRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> paymentService.updatePayment(1L, new Payment()));
        verify(payment).getId();
        verify(iPaymentRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link PaymentService#updatePayment(Long, Payment)}
     */
    @Test
    void testUpdatePayment4() {
        // Arrange
        Optional<Payment> emptyResult = Optional.empty();
        when(iPaymentRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        new ResourceNotFoundException("An error occurred");

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> paymentService.updatePayment(1L, new Payment()));
        verify(iPaymentRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link PaymentService#deletePayment(Long)}
     */
    @Test
    void testDeletePayment() {
        // Arrange
        doNothing().when(iPaymentRepository).delete(Mockito.<Payment>any());
        Optional<Payment> ofResult = Optional.of(new Payment());
        when(iPaymentRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        paymentService.deletePayment(1L);

        // Assert that nothing has changed
        verify(iPaymentRepository).delete(isA(Payment.class));
        verify(iPaymentRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link PaymentService#deletePayment(Long)}
     */
    @Test
    void testDeletePayment2() {
        // Arrange
        doThrow(new ResourceNotFoundException("An error occurred")).when(iPaymentRepository).delete(Mockito.<Payment>any());
        Optional<Payment> ofResult = Optional.of(new Payment());
        when(iPaymentRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> paymentService.deletePayment(1L));
        verify(iPaymentRepository).delete(isA(Payment.class));
        verify(iPaymentRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link PaymentService#deletePayment(Long)}
     */
    @Test
    void testDeletePayment3() {
        // Arrange
        Optional<Payment> emptyResult = Optional.empty();
        when(iPaymentRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> paymentService.deletePayment(1L));
        verify(iPaymentRepository).findById(eq(1L));
    }
}
