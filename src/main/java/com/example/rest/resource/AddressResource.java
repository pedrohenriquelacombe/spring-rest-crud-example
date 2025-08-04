package com.example.rest.resource;

import com.example.rest.annotation.RequestDTO;
import com.example.rest.dto.mapper.AddressMapper;
import com.example.rest.dto.request.AddressRequestDTO;
import com.example.rest.dto.response.AddressResponseDTO;
import com.example.rest.entity.Address;
import com.example.rest.service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@AllArgsConstructor
public class AddressResource {

    private AddressService addressService;

    @PatchMapping("/students/{id}/addresses")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponseDTO update(@PathVariable String id, @Valid @RequestDTO(AddressRequestDTO.class) Address address) {
        return AddressMapper.toResponse(this.addressService.update(id, address));
    }

}
