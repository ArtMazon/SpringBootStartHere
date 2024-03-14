package com.springpractice.chapter14exercise.controllers;

import com.springpractice.chapter14exercise.model.Account;
import com.springpractice.chapter14exercise.model.TransferRequest;
import com.springpractice.chapter14exercise.services.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService){
        this.transferService = transferService;
    }


    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest transferRequest
            ){

        transferService.transferMoney(
                transferRequest.getIdSender(),
                transferRequest.getIdReceiver(),
                transferRequest.getAmount()
        );


    }

    @GetMapping("/accounts")
    public Iterable<Account> findAllAccounts(
            @RequestParam(required = false) String name
    ){

        if(name == null){
            return transferService.getAllAccounts();

        }else {

            return transferService.findAccountByName(name);

        }


    }



}
