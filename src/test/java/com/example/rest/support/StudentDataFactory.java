package com.example.rest.support;

import com.example.rest.dto.request.AddressRequestDTO;
import com.example.rest.dto.request.StudentRequestDTO;
import com.example.rest.entity.Address;
import com.example.rest.entity.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentDataFactory {

    private static final AtomicInteger counter = new AtomicInteger();
    private static final LocalDateTime NOW = LocalDateTime.now();

    public static Student buildStudent() {
        var student = new Student();

        student.setId(UUID.randomUUID().toString());
        student.setName(String.format("Foo %d", counter.incrementAndGet()));
        student.setEmail(String.format("foo_%d@gmail.com", counter.get()));
        student.setBirthday(LocalDate.of(1992, 8, 28));
        student.setCreatedAt(NOW);
        student.setUpdatedAt(NOW);
        student.setAddress(buildAddress());

        return student;
    }

    public static StudentRequestDTO buildStudentRequest() {
        var student = buildStudent();
        var request = new StudentRequestDTO();

        request.setName(student.getName());
        request.setEmail(student.getEmail());
        request.setBirthday(student.getBirthday());
        request.setAddress(buildAddressRequest());

        return request;
    }

    private static Address buildAddress() {
        var address = new Address();

        address.setId(UUID.randomUUID().toString());
        address.setZipCode("FooZipCode");
        address.setStreet("Foo Street");
        address.setNumber("111");
        address.setComplement("222");
        address.setDistrict("FooDistrict");
        address.setCity("FooCity");
        address.setState("FooState");
        address.setCountry("FooCountry");
        address.setCreatedAt(NOW);
        address.setUpdatedAt(NOW);

        return address;
    }

    private static AddressRequestDTO buildAddressRequest() {
        var address = buildAddress();
        var request = new AddressRequestDTO();

        request.setZipCode(address.getZipCode());
        request.setStreet(address.getStreet());
        request.setNumber(address.getNumber());
        request.setComplement(address.getComplement());
        request.setDistrict(address.getDistrict());
        request.setCity(address.getCity());
        request.setState(address.getState());
        request.setCountry(address.getCountry());

        return request;
    }

}
