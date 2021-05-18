package com.example.rest.dto;

import com.example.rest.entity.Student;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO extends RepresentationModel<StudentDTO> {

    public interface CreateStudentGroup {
    }

    private String id;

    @NotEmpty(message = "{NotEmpty.name}")
    private String name;

    @Email
    @NotEmpty(message = "{NotEmpty.email}")
    private String email;

    @NotEmpty(message = "{NotEmpty.password}", groups = CreateStudentGroup.class)
    private String password;

    @NotNull(message = "{NotNull.birthday}")
    private LocalDate birthday;

    @Valid
    @NotNull(message = "{NotNull.address}")
    private AddressDTO address;

    public static StudentDTO getInstance(Student student) {
        StudentDTO dto = StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .birthday(student.getBirthday())
                .build();

        Optional.ofNullable(student.getAddress()).ifPresent(address -> {
            dto.setAddress(AddressDTO.getInstance(address));
        });

        return dto;
    }

    public static List<StudentDTO> getInstance(List<Student> students) {
        return students.stream().map(StudentDTO::getInstance).collect(Collectors.toList());
    }

}
