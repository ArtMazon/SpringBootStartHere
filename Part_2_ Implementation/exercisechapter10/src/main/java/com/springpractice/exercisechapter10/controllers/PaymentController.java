package com.springpractice.exercisechapter10.controllers;


import com.springpractice.exercisechapter10.exceptions.NotEnoughMoneyException;
import com.springpractice.exercisechapter10.models.ErrorDetails;
import com.springpractice.exercisechapter10.models.PaymentDetails;
import com.springpractice.exercisechapter10.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;

    }

    @PostMapping("/payment")

    public ResponseEntity<PaymentDetails> makePayment(){

            PaymentDetails paymentDetails = paymentService.processPayment();

            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);

    }
}
