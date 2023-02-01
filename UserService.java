package com.sapient.productCatalogue.service;

import com.sapient.productCatalogue.entity.User;
import com.sapient.productCatalogue.request.LoginRequest;
import com.sapient.productCatalogue.request.ResetPasswordRequest;
import com.sapient.productCatalogue.response.LoginResponse;
import org.hibernate.service.spi.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    LoginResponse login(LoginRequest request);

    String logout(String email);

    User register(User user) throws ServiceException;

    User updateUser(User user);

    String resetPassword(ResetPasswordRequest request, String email);

    Optional<User> getUserByEmail(String email);

    List<User> getUsers();

}
