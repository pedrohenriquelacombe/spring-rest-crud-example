package com.example.rest.service;

import com.example.rest.entity.Student;
import com.example.rest.repository.AddressRepository;
import com.example.rest.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private AddressRepository addressRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    public Student save(Student student) {
        Optional.ofNullable(student.getAddress()).ifPresent(address -> address.setStudent(student));

        return this.studentRepository.save(student);
    }

    public Student update(String id, Student student) {
        Student aux = this.studentRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(student, aux, "id", "savedAt", "updatedAt", "address");

        this.studentRepository.save(aux);

        Optional.ofNullable(student.getAddress()).ifPresent(address -> {
            BeanUtils.copyProperties(student.getAddress(), aux.getAddress(), "id", "savedAt", "updatedAt", "student");
            this.addressRepository.save(aux.getAddress());
        });

        return aux;
    }

    public void deleteById(String id) {
        Student student = this.studentRepository.findById(id).orElseThrow();
        this.studentRepository.delete(student);
    }

}
