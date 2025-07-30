package com.example.rest.dto.mapper;

import com.example.rest.dto.response.StudentResponseDTO;
import com.example.rest.entity.Student;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StudentMapper {

    public static StudentResponseDTO toResponse(Student student) {
        if (ObjectUtils.isEmpty(student)) {
            return null;
        }

        StudentResponseDTO dto = StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .birthday(student.getBirthday())
                .build();

        Optional.ofNullable(student.getAddress()).ifPresent(address -> {
            dto.setAddress(AddressMapper.toResponse(address));
        });

        return dto;
    }

    public static List<StudentResponseDTO> toResponseList(List<Student> students) {
        return students.stream().map(StudentMapper::toResponse).collect(Collectors.toList());
    }

}
