package com.example.rest.resource;

import com.example.rest.annotation.RequestDTO;
import com.example.rest.api.ViaCepAPI;
import com.example.rest.dto.AddressDTO;
import com.example.rest.dto.mapper.AddressMapper;
import com.example.rest.entity.Address;
import com.example.rest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class AddressResource {

    private ViaCepAPI viaCepAPI;
    private AddressService addressService;

    @Autowired
    public AddressResource(ViaCepAPI viaCepAPI, AddressService addressService) {
        this.viaCepAPI = viaCepAPI;
        this.addressService = addressService;
    }

    @PatchMapping("/students/{id}/addresses")
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO update(@PathVariable String id, @Valid @RequestDTO(AddressDTO.class) Address address) {
        return AddressMapper.getInstance(this.addressService.update(id, address));
    }

    @GetMapping("/addresses/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO search(@PathVariable String cep) {
        return AddressMapper.getInstance(this.viaCepAPI.search(cep));
    }

}
