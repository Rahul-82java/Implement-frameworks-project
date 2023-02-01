package com.sapient.productCatalogue.service;

import com.sapient.productCatalogue.entity.User;
import com.sapient.productCatalogue.repository.UserRepository;
import com.sapient.productCatalogue.request.LoginRequest;
import com.sapient.productCatalogue.request.ResetPasswordRequest;
import com.sapient.productCatalogue.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    public LoginResponse login(LoginRequest request) {
        try {

            Optional<User> dbUser = getUserByEmail(request.getEmail());
            if (dbUser.isEmpty()) {
                throw new RuntimeException("User doesn't exist for the given email and password");
            }
            User updatedUser = updateUser(dbUser.get());
            return LoginResponse.builder()
                    .email(updatedUser.getEmail())
                    .build();
        } catch (RuntimeException e) {
            log.error("Error occured while logging into system due to : {}", e.getMessage());
            throw new RuntimeException("User does not exist for the given email and password");
        }
    }

    public String logout(String email) {
        Optional<User> user = getUserByEmail(email);
        User loggedOutUser = updateUser(user.get());
        return "User " + loggedOutUser.getFirstName().toUpperCase() + " logged out successfully";

    }

    public String resetPassword(ResetPasswordRequest request, String email) {
        Optional<User> user = userRepo.findByEmail(email);

        if(user != null && user.get() != null ){
            user.get().setPassword(request.getNewPassword());
            updateUser(user.get());
            return "Password updated successfully.";
        }else{
            throw new RuntimeException("Password reset request is invalid, Please contact system administrator.");
        }
    }

    @Transactional
    @Override
    public User register(User newUser) {
        log.debug("+++ Register new user : {} +++", newUser.getEmail());
        if (userRepo.existsByEmailIgnoreCase(newUser.getEmail())) {
            String message = String.format("User [%s] already exists in db.", newUser.getEmail());
            log.info(message);
            throw new RuntimeException(message);
        }
        newUser.setPassword(newUser.getPassword());
        log.debug("Saving newUser [%] in db", newUser.getEmail());
        try {
            newUser = userRepo.save(newUser);
            log.debug("NewUser [%] saved in db", newUser.getEmail());
            log.debug("--- Register new user : {} ---", newUser.getEmail());
            return newUser;
        } catch (Exception exception) {
            log.error("Exception occured in register() due to : {}", exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }

    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isEmpty()) {
            throw new RuntimeException("User does not exist in database for given email.");
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

}
