package com.damine.productservice.exceptions;

import lombok.*;

@Getter
@Data
@AllArgsConstructor
public class ValidationError {
    private String field;
    private String errorMessage;
}

