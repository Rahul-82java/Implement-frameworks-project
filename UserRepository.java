package com.sapient.productCatalogue.repository;

import com.sapient.productCatalogue.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByEmailAndFirstNameAndLastName(String email,String firstName,String lastName);

}
