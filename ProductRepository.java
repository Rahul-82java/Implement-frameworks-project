package com.sapient.productCatalogue.repository;

import com.sapient.productCatalogue.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

   Product findByName(String productName);
   boolean existsById(Integer id);
}
