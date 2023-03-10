package com.sapient.productCatalogue.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductNotFoundException extends RuntimeException {
    private int httpStatusCode;
    private String message;

}
