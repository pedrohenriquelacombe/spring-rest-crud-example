package com.example.rest.dto.mapper;

import com.example.rest.support.StudentDataFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentMapperTest {

    @Test
    public void shouldReturnNullWhenInputIsNull() {
        var studentResponseDTO = StudentMapper.toResponse(null);

        assertNull(studentResponseDTO);
    }

    @Test
    public void shouldMapStudentToStudentResponseDTO() {
        var student = StudentDataFactory.buildStudent();
        var studentResponseDTO = StudentMapper.toResponse(student);

        assertNotNull(studentResponseDTO);

        assertAll("Student fields",
                () -> assertEquals(student.getId(), studentResponseDTO.getId()),
                () -> assertEquals(student.getName(), studentResponseDTO.getName()),
                () -> assertEquals(student.getEmail(), studentResponseDTO.getEmail()),
                () -> assertEquals(student.getBirthday(), studentResponseDTO.getBirthday())
        );

        var address = student.getAddress();
        var addressResponseDTO = studentResponseDTO.getAddress();

        assertAll("Address fields",
                () -> assertEquals(address.getId(), addressResponseDTO.getId()),
                () -> assertEquals(address.getZipCode(), addressResponseDTO.getZipCode()),
                () -> assertEquals(address.getStreet(), addressResponseDTO.getStreet()),
                () -> assertEquals(address.getNumber(), addressResponseDTO.getNumber()),
                () -> assertEquals(address.getComplement(), addressResponseDTO.getComplement()),
                () -> assertEquals(address.getDistrict(), addressResponseDTO.getDistrict()),
                () -> assertEquals(address.getState(), addressResponseDTO.getState()),
                () -> assertEquals(address.getCity(), addressResponseDTO.getCity())
        );
    }

}
