package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.Payment;
import com.HotelAndRest.springProject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // GET: /payments
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    // GET: /payments/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") int payId) {
        Payment payment = paymentService.getPaymentById(payId);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: /payments
    @PostMapping
    public ResponseEntity<String> addPayment(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
        return new ResponseEntity<>("Payment added successfully.", HttpStatus.CREATED);
    }

    // PUT: /payments/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePayment(@PathVariable("id") int payId, @RequestBody Payment payment) {
        payment.setPayId(payId);
        paymentService.updatePayment(payment);
        return new ResponseEntity<>("Payment updated successfully.", HttpStatus.OK);
    }

    // DELETE: /payments/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable("id") int payId) {
        paymentService.deletePayment(payId);
        return new ResponseEntity<>("Payment deleted successfully.", HttpStatus.OK);
    }
}
