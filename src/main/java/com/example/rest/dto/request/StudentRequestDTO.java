package com.example.rest.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class StudentRequestDTO {

    @NotEmpty(message = "{NotEmpty.name}")
    private String name;

    @Email
    @NotEmpty(message = "{NotEmpty.email}")
    private String email;

    @NotNull(message = "{NotNull.birthday}")
    private LocalDate birthday;

    @Valid
    @NotNull(message = "{NotNull.address}")
    private AddressRequestDTO address;

}
