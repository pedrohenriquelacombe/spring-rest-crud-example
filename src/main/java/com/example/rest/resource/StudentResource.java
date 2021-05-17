package com.example.rest.resource;

import com.example.rest.annotation.RequestDTO;
import com.example.rest.dto.AddressDTO;
import com.example.rest.dto.StudentDTO;
import com.example.rest.entity.Address;
import com.example.rest.entity.Student;
import com.example.rest.repository.StudentRepository;
import com.example.rest.service.AddressService;
import com.example.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentResource {

    private StudentService studentService;
    private AddressService addressService;
    private StudentRepository studentRepository;

    @Autowired
    public StudentResource(StudentService studentService, AddressService addressService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.addressService = addressService;
        this.studentRepository = studentRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> students() {
        return StudentDTO.getInstance(this.studentRepository.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO search(@PathVariable String id) {
        StudentDTO studentDTO = StudentDTO.getInstance(this.studentRepository.findById(id).orElseThrow());
        return studentDTO;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO create(@Validated(value = {Default.class, StudentDTO.CreateStudentGroup.class}) @RequestDTO(StudentDTO.class) Student student) {
        return StudentDTO.getInstance(this.studentService.save(student));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO update(@PathVariable String id, @Valid @RequestDTO(StudentDTO.class) Student student) {
        return StudentDTO.getInstance(this.studentService.update(id, student));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO updateAddress(@PathVariable String id, @Valid @RequestDTO(AddressDTO.class) Address address) {
        return AddressDTO.getInstance(this.addressService.update(id, address));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        this.studentService.deleteById(id);
    }

}
