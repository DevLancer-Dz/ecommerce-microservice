package com.damine.authservice.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCredentialRequestDto extends UserCredentialDto {
    private String password;
    private PasswordEncoder passwordEncoder;

    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password);
    }
}
