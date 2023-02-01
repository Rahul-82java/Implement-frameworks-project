package com.sapient.productCatalogue.request;


import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class ResetPasswordRequest {

    @NotBlank(message = "New Password can not be blank")
    private String newPassword;

}
