package com.damine.authservice.http.response;

import com.damine.authservice.DTO.AbstractDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCredentialResponse extends AbstractDto<Long> {
    private String name;
    private String email;
}
