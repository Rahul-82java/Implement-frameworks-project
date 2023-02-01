package com.sapient.productCatalogue.service;

import com.sapient.productCatalogue.entity.Seller;
import com.sapient.productCatalogue.exception.ProductNotFoundException;

public interface SellerService {

    Seller createSeller(Seller seller) throws ProductNotFoundException;
}
