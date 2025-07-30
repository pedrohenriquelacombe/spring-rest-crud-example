package com.example.rest.resource;

import com.example.rest.dto.response.StudentResponseDTO;
import com.example.rest.repository.StudentRepository;
import com.example.rest.support.StudentDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentResourceTests {

    private static final String BASE_URL = "/students";

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void cleanDatabase() {
        this.studentRepository.deleteAll();
    }

    @Test
    public void shouldReturnListOfStudents() {
        this.restTemplate.postForLocation(BASE_URL, StudentDataFactory.buildStudentRequest());
        this.restTemplate.postForLocation(BASE_URL, StudentDataFactory.buildStudentRequest());
        this.restTemplate.postForLocation(BASE_URL, StudentDataFactory.buildStudentRequest());

        var response = this.restTemplate.getForEntity(BASE_URL, StudentResponseDTO[].class);

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().length >= 3);
    }

    @Test
    public void shouldReturnEmptyListWhenNoStudentsExist() {
        var response = this.restTemplate.getForEntity(BASE_URL, StudentResponseDTO[].class);

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody().length);
    }

    @Test
    public void shouldCreateStudentWhenGivenValidData() {
        var request = StudentDataFactory.buildStudentRequest();
        var postResponse = this.restTemplate.postForEntity(BASE_URL, request, StudentResponseDTO.class);

        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());

        var getRequestUrl = String.format("/%s/%s", BASE_URL, postResponse.getBody().getId());
        var getResponse = this.restTemplate.getForEntity(getRequestUrl, StudentResponseDTO.class);

        assertNotNull(getResponse.getBody());
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
    }

    @Test
    public void shouldUpdateStudentWhenGivenValidData() {
        var postRequest = StudentDataFactory.buildStudentRequest();
        var postResponse = this.restTemplate.postForEntity(BASE_URL, postRequest, StudentResponseDTO.class);

        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());

        var name = "FooBar";
        var email = "foobar@gmail.com";
        var putRequest = StudentDataFactory.buildStudent();

        putRequest.setName(name);
        putRequest.setEmail(email);

        var url = String.format("/%s/%s", BASE_URL, postResponse.getBody().getId());

        this.restTemplate.put(url, putRequest);

        var getResponse = this.restTemplate.getForEntity(url, StudentResponseDTO.class);

        assertNotNull(getResponse.getBody());
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertEquals(name, getResponse.getBody().getName());
        assertEquals(email, getResponse.getBody().getEmail());
    }

    @Test
    public void shouldDeleteStudentWhenIdExists() {
        var request = StudentDataFactory.buildStudentRequest();
        var postResponse = this.restTemplate.postForEntity(BASE_URL, request, StudentResponseDTO.class);

        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());

        var url = String.format("/%s/%s", BASE_URL, postResponse.getBody().getId());

        var deleteResponse = this.restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);

        assertNull(deleteResponse.getBody());
        assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatusCode());

        var getResponse = this.restTemplate.getForEntity(url, StudentResponseDTO.class);

        assertNull(getResponse.getBody());
        assertEquals(HttpStatus.NOT_FOUND, getResponse.getStatusCode());
    }

    @Test
    public void shouldReturn404WhenGettingNonExistingStudent() {
        var url = String.format("/%s/%s", BASE_URL, UUID.randomUUID());
        var response = this.restTemplate.getForEntity(url, StudentResponseDTO.class);

        assertNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void shouldReturn404WhenDeletingNonExistingStudent() {
        var url = String.format("/%s/%s", BASE_URL, UUID.randomUUID());
        var response = this.restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);

        assertNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
