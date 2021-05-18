package com.example.rest.dto.mapper;

import com.example.rest.api.ViaCepAPI;
import com.example.rest.dto.AddressDTO;
import com.example.rest.entity.Address;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AddressMapper {

    public static AddressDTO getInstance(Address address) {
        return AddressDTO.builder()
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

    public static AddressDTO getInstance(ViaCepAPI.ViaCepAddress address) {
        return AddressDTO.builder()
                .zipCode(address.getCep())
                .street(address.getLogradouro())
                .complement(address.getComplemento())
                .district(address.getBairro())
                .city(address.getLocalidade())
                .state(address.getUf())
                .build();
    }

}
