package com.example.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponseDTO {

    private String id;
    private String name;
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    private AddressResponseDTO address;

}
