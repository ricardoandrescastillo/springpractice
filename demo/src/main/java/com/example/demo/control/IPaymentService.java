package com.example.demo.control;

import com.example.demo.entity.Payment;

import java.util.List;
import java.util.Optional;

public interface IPaymentService {

    Optional<Payment> getPaymentById(Long id) ;

    List<Payment> getAllPayments();

    Payment createPayment(Payment payment);

    Payment updatePayment(Long id, Payment paymentDetails);

    public void deletePayment(Long id) ;
}
