package com.matejgeljic.taskflow.domain.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private Long id;
    @NotNull(message = "100")
    @NotEmpty(message = "100")
    private String firstName;
    @NotNull(message = "101")
    @NotEmpty(message = "101")
    private String lastName;
    @NotNull(message = "103")
    @NotEmpty(message = "103")
    @Email
    private String email;
    @NotNull(message = "104")
    @NotEmpty(message = "104")
    @Pattern(regexp="(^$|[0-9]{10})", message = "105")
    private String phone;
    @NotNull(message = "106")
    @NotEmpty(message = "106")
    private String address;
    @NotNull(message = "107")
    @NotEmpty(message = "107")
    private String city;
    @NotNull(message = "108")
    @NotEmpty(message = "108")
    private String zipCode;
    @NotNull(message = "109")
    @NotEmpty(message = "109")
    private String country;
}
