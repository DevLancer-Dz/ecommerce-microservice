package com.damine.authservice.http.request;

import com.damine.authservice.DTO.AbstractDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthRequest extends AbstractDto<Long> {
    private String name;
    private String password;
}
