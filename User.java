package com.sapient.productCatalogue.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Please provide first name.")
    private String firstName;

    @NotBlank(message = "Please provide last name.")
    private String lastName;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Please provide password.")
    private String password;

    @NotBlank(message = "Please provide phone number.")
    @Size(
            min = 10,
            max= 10,
            message = "Please provide phone number of 10 digit only."
    )
    private String phoneNo;

    @Email(message = "Please provide valid email.")
    @NotBlank(message = "Please provide email.")
    @Column(unique = true,updatable = false)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean isActive= true;

}


