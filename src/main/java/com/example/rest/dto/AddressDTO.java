package com.example.rest.dto;

import com.example.rest.entity.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {

    private String id;

    @NotEmpty
    private String street;

    @NotEmpty
    private String number;

    private String complement;

    @NotEmpty
    private String district;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @NotEmpty
    private String country;

    public static AddressDTO getInstance(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .street(address.getStreet())
                .number(address.getNumber())
                .complement(address.getComplement())
                .district(address.getDistrict())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .build();
    }

}
