package com.sapient.productCatalogue.controller;

import com.sapient.productCatalogue.entity.User;
import com.sapient.productCatalogue.request.LoginRequest;
import com.sapient.productCatalogue.request.ResetPasswordRequest;
import com.sapient.productCatalogue.response.LoginResponse;
import com.sapient.productCatalogue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private static final String ENDPOINT_LOGIN = "/login";
    private static final String ENDPOINT_LOGOUT = "/logout";
    private static final String ENDPOINT_RESET_PASSWORD = "/resetPassword";
    private static final String ENDPOINT_FORGOT_PASSWORD = "/forgotPassword";

    @Autowired
    private UserService userService;
    
    @PostMapping("register")
    public User register(@Valid @RequestBody User request) {
        return userService.register(request);
    }
   
    @PostMapping(ENDPOINT_LOGIN)
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return userService.login(request);
    }
    
    @PostMapping(ENDPOINT_LOGOUT)
    public String logout(@PathVariable("email") String email) {
        return userService.logout(email);
    }

    @PostMapping(ENDPOINT_RESET_PASSWORD)
    public String resetPassword(@Valid @RequestBody ResetPasswordRequest request, @RequestParam("email") String email) {
        return userService.resetPassword(request, email);
    }


}
