package com.axipays.controller;

import com.axipays.model.Payment;
import com.axipays.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users/{userId}/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

 @PostMapping
    public ResponseEntity<?> addPayment(@PathVariable Long userId, @RequestBody Payment payment) {
        try {
            Payment savedPayment = paymentService.addPayment(userId, payment);
            return ResponseEntity.ok(savedPayment);
            
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));

        } catch (Exception e) {
          
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", "Unexpected error occurred"));
        }
    }


    @GetMapping
    public ResponseEntity<?> getPayments(@PathVariable Long userId) {
        try {
            List<Payment> payments = paymentService.getPaymentsByUser(userId);
            return ResponseEntity.ok(payments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", "Unable to fetch payments"));
        }
    }
}
