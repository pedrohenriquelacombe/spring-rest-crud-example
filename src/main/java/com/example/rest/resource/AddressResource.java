package com.example.rest.resource;

import com.example.rest.annotation.RequestDTO;
import com.example.rest.dto.AddressDTO;
import com.example.rest.entity.Address;
import com.example.rest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/students/{id}/addresses")
public class AddressResource {

    private AddressService addressService;

    @Autowired
    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO update(@PathVariable String id, @Valid @RequestDTO(AddressDTO.class) Address address) {
        return AddressDTO.getInstance(this.addressService.update(id, address));
    }

}
