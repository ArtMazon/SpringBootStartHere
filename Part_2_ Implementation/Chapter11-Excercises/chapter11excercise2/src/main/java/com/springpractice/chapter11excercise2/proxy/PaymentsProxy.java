package com.springpractice.chapter11excercise2.proxy;


import com.springpractice.chapter11excercise2.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Controller
public class PaymentsProxy {

    private final RestTemplate rest;

    @Value("${service.name.url}")
    private String paymentServiceUrl;

    public PaymentsProxy(RestTemplateBuilder rest){
        this.rest = rest.build();
    }

    public Payment createPayment(Payment payment){

        String uri = paymentServiceUrl +"/payment";
        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment,headers);

        ResponseEntity<Payment> response =
                rest.exchange(uri,
                        HttpMethod.POST,
                        httpEntity,
                        Payment.class);

        return response.getBody();


    }
}
