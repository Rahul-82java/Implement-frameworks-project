package com.sapient.productCatalogue.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class ForgetPasswordRequest {

    @NotBlank(message = "please provide email")
    @Email(message = "please provide valid email")
    private String email;

}
