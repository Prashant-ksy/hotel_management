package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.Payment;
import com.HotelAndRest.springProject.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Add a new payment
    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payment by Pay ID
    public Payment getPaymentById(int payId) {
        return paymentRepository.findById(payId);
    }

    // Update payment
    public void updatePayment(Payment payment) {
        paymentRepository.update(payment);
    }

    // Delete payment by Pay ID
    public void deletePayment(int payId) {
        paymentRepository.delete(payId);
    }
}
