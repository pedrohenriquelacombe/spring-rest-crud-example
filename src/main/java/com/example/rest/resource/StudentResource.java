package com.example.rest.resource;

import com.example.rest.annotation.RequestDTO;
import com.example.rest.dto.mapper.StudentMapper;
import com.example.rest.dto.request.StudentRequestDTO;
import com.example.rest.dto.response.StudentResponseDTO;
import com.example.rest.entity.Student;
import com.example.rest.repository.StudentRepository;
import com.example.rest.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentResource {

    private StudentService studentService;
    private StudentRepository studentRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponseDTO> students() {
        return StudentMapper.toResponseList(this.studentRepository.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDTO create(@Valid @RequestDTO(StudentRequestDTO.class) Student student) {
        return StudentMapper.toResponse(this.studentService.save(student));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponseDTO search(@PathVariable String id) {
        return StudentMapper.toResponse(this.studentService.findById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponseDTO update(@PathVariable String id, @Valid @RequestDTO(StudentRequestDTO.class) Student student) {
        return StudentMapper.toResponse(this.studentService.update(id, student));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        this.studentService.deleteById(id);
    }

}
