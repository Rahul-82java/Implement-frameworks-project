package com.sapient.productCatalogue.repository;

import com.sapient.productCatalogue.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository  extends JpaRepository<Seller, Integer> {
}
