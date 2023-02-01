package com.sapient.productCatalogue.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank(message = "please provide email")
    @Email(message = "please provide valid email")
    private String email;

    @NotBlank(message = "please provide password")
    private String password;
}
