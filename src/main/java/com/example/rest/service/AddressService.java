package com.example.rest.service;

import com.example.rest.entity.Address;
import com.example.rest.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    public Address update(String id, Address address) {
        Address aux = this.addressRepository.findByStudentId(id).orElseThrow();
        BeanUtils.copyProperties(address, aux, "id", "createdAt", "updatedAt", "student");
        return this.addressRepository.save(aux);
    }

}
