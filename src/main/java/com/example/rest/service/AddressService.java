package com.example.rest.service;

import com.example.rest.entity.Address;
import com.example.rest.entity.Student;
import com.example.rest.repository.AddressRepository;
import com.example.rest.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private StudentRepository studentRepository;
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    public Address update(String id, Address address) {
        Student aux = this.studentRepository.findById(id).orElseThrow();

        BeanUtils.copyProperties(address, aux.getAddress(), "id", "savedAt", "updatedAt", "student");
        return this.addressRepository.save(aux.getAddress());
    }

}
