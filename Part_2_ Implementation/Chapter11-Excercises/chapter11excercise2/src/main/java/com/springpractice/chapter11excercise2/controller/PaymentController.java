package com.springpractice.chapter11excercise2.controller;


import com.springpractice.chapter11excercise2.model.Payment;
import com.springpractice.chapter11excercise2.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentsProxy paymentsProxy;

    PaymentController(PaymentsProxy paymentsProxy){
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ){

        return  paymentsProxy.createPayment(payment);

    }
}
