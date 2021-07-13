package com.example.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressResponseDTO {

    private String id;
    private String zipCode;
    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country;

}
