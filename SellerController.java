package com.sapient.productCatalogue.controller;


import com.sapient.productCatalogue.entity.Product;
import com.sapient.productCatalogue.entity.Seller;
import com.sapient.productCatalogue.exception.ProductNotFoundException;
import com.sapient.productCatalogue.service.ProductService;
import com.sapient.productCatalogue.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/")
    public ResponseEntity<Object> createSeller(@RequestBody Seller seller) throws ProductNotFoundException  {
        return new ResponseEntity<>(sellerService.createSeller(seller), HttpStatus.CREATED);
    }
}
