package com.damine.authservice.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCredentialDto extends AbstractDto<Long>{
    private String name;
    private String email;
}
