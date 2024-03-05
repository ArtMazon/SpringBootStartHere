package com.chapter8.excersiechapter8.controller;


import com.chapter8.excersiechapter8.Services.ProductService;
import com.chapter8.excersiechapter8.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class ProductsController {

    private Logger logger = Logger.getLogger(ProductsController.class.getName());
    private final ProductService productService ;

    public ProductsController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProduct(Model model){

        var products = productService.findAll();

        model.addAttribute("products",products);

        return "products.html";



    }

    @PostMapping("/products")
    public String addProduct(@RequestParam String name, @RequestParam double price, Model model){

        logger.info("Creating product with name : "+name+ " and price: "+price);

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);



        var products = productService.findAll();
        model.addAttribute("products",products);

        return "products.html";

    }
}
