package com.example.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
