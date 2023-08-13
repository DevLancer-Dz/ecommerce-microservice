package com.damine.authservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@AllArgsConstructor
public class ValidationError {
    private String field;
    private String errorMessage;
}

