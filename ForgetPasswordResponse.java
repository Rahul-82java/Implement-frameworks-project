package com.sapient.productCatalogue.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ForgetPasswordResponse {

    private String url;
    private String message;
}
