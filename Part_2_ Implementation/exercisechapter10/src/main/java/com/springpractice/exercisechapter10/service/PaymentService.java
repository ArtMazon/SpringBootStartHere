package com.springpractice.exercisechapter10.service;


import com.springpractice.exercisechapter10.exceptions.NotEnoughMoneyException;
import com.springpractice.exercisechapter10.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }

}
