package com.sapient.productCatalogue.service;

import com.sapient.productCatalogue.entity.Product;
import com.sapient.productCatalogue.entity.Seller;
import com.sapient.productCatalogue.exception.ProductNotFoundException;
import com.sapient.productCatalogue.repository.ProductRepository;
import com.sapient.productCatalogue.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Seller createSeller(Seller seller) throws ProductNotFoundException{
        Product byProductName = Optional.of(productRepository.findByName(seller.getProductName())).orElseThrow(() -> {
            throw new ProductNotFoundException(HttpStatus.UNAUTHORIZED.value(),"Product not found exception");
        });
        seller.setProductId(byProductName.getProductId());
        return sellerRepository.save(seller);
    }
}
