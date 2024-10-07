package com.matejgeljic.taskflow.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private UUID id;
    @NotBlank(message = "100")
    private String firstName;
    @NotBlank(message = "101")
    private String lastName;
    @NotBlank(message = "102")
    @Email
    private String email;
    @NotBlank(message = "104")
    @Pattern(regexp="(^$|[0-9]{10})", message = "105")
    private String phone;
    @NotBlank(message = "106")
    private String address;
    @NotBlank(message = "107")
    private String city;
    @NotBlank(message = "108")
    private String zipCode;
    @NotBlank(message = "109")
    private String country;
}
