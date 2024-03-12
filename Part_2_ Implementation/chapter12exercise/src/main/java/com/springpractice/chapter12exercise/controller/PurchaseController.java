package com.springpractice.chapter12exercise.controller;

import com.springpractice.chapter12exercise.model.Purchase;
import com.springpractice.chapter12exercise.repositories.PurchaseRepositoryoriginal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepositoryoriginal purchaseRepository;

    PurchaseController(PurchaseRepositoryoriginal purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase){
        purchaseRepository.storePurchase(purchase);
    }

    @GetMapping
    public List<Purchase> findPurchase(){
      return   purchaseRepository.findAllPurchases();
    }
}
