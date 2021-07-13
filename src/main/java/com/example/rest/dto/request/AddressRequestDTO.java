package com.example.rest.dto.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {

    @NotEmpty(message = "{NotEmpty.zipCode}")
    private String zipCode;

    @NotEmpty(message = "{NotEmpty.street}")
    private String street;

    @NotEmpty(message = "{NotEmpty.number}")
    private String number;

    private String complement;

    @NotEmpty(message = "{NotEmpty.district}")
    private String district;

    @NotEmpty(message = "{NotEmpty.city}")
    private String city;

    @NotEmpty(message = "{NotEmpty.state}")
    private String state;

    @NotEmpty(message = "{NotEmpty.country}")
    private String country;

}
