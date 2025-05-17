package com.axipays.service;

import com.axipays.model.Payment;
import com.axipays.model.User;
import com.axipays.repository.PaymentRepository;
import com.axipays.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    
    public Payment addPayment(Long userId, Payment payment) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        
        if (!isValidCardNumber(payment.getCardNo())) {
            throw new IllegalArgumentException("Invalid card number (Luhn check failed)");
        }

      
        payment.setUser(user);
        payment.setCreatedAt(LocalDateTime.now());

        Payment saved = paymentRepository.save(payment);

        
        saved.setCardNo(maskCardNumber(saved.getCardNo()));
        return saved;
    }

    public List<Payment> getPaymentsByUser(Long userId) {
        return paymentRepository.findByUserId(userId);
    }

   
    public boolean isValidCardNumber(String cardNo) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNo.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNo.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) n -= 9;
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    
    public String maskCardNumber(String cardNo) {
        if (cardNo == null || cardNo.length() < 4) return "****";
        return "**** **** **** " + cardNo.substring(cardNo.length() - 4);
    }
}
