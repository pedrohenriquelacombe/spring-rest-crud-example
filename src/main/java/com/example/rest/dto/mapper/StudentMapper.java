package com.example.rest.dto.mapper;

import com.example.rest.dto.response.StudentResponseDTO;
import com.example.rest.entity.Student;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StudentMapper {

    public static StudentResponseDTO getInstance(Student student) {
        StudentResponseDTO dto = StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .birthday(student.getBirthday())
                .build();

        Optional.ofNullable(student.getAddress()).ifPresent(address -> {
            dto.setAddress(AddressMapper.getInstance(address));
        });

        return dto;
    }

    public static List<StudentResponseDTO> getInstance(List<Student> students) {
        return students.stream().map(StudentMapper::getInstance).collect(Collectors.toList());
    }

}
