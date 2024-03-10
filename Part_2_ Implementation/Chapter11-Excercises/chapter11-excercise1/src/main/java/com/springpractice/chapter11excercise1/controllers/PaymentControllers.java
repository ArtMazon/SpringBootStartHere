package com.springpractice.chapter11excercise1.controllers;


import com.springpractice.chapter11excercise1.model.Payment;
import com.springpractice.chapter11excercise1.proxies.PaymentProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentControllers {

    private final PaymentProxy paymentProxy;

    PaymentControllers(PaymentProxy paymentProxy){
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment){
        String requestId = UUID.randomUUID().toString();

        return paymentProxy.createPayment(requestId,payment);

    }
}
