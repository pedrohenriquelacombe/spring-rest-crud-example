package com.example.rest.service;

import com.example.rest.entity.Student;
import com.example.rest.repository.AddressRepository;
import com.example.rest.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;
    private AddressRepository addressRepository;

    public Student findById(String id) {
        return this.studentRepository.findById(id).orElseThrow();
    }

    public Student save(Student student) {
        Optional.ofNullable(student.getAddress()).ifPresent(address -> address.setStudent(student));

        return this.studentRepository.save(student);
    }

    public Student update(String id, Student student) {
        Student aux = this.findById(id);
        BeanUtils.copyProperties(student, aux, "id", "createdAt", "updatedAt", "address");

        this.studentRepository.save(aux);

        Optional.ofNullable(student.getAddress()).ifPresent(address -> {
            BeanUtils.copyProperties(student.getAddress(), aux.getAddress(), "id", "createdAt", "updatedAt", "student");
            this.addressRepository.save(aux.getAddress());
        });

        return aux;
    }

    public void deleteById(String id) {
        this.studentRepository.delete(this.findById(id));
    }

}
