package com.example.rest.resource.exceptionHandler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FieldError {

    private String field;
    private String message;

    public FieldError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public static List<FieldError> getInstance(BindingResult result) {
        return result.getFieldErrors().stream()
                .map(error -> new FieldError(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
    }

}
