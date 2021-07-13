package com.example.rest.dto.mapper;

import com.example.rest.dto.response.AddressResponseDTO;
import com.example.rest.entity.Address;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AddressMapper {

    public static AddressResponseDTO getInstance(Address address) {
        return AddressResponseDTO.builder()
                .id(address.getId())
                .zipCode(address.getZipCode())
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
