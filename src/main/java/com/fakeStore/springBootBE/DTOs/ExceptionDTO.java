package com.fakeStore.springBootBE.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionDTO {
    private int statusCode;
    private String message;
}
