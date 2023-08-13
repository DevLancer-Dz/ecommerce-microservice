package com.damine.authservice.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class UserCredential extends AbstractEntity<Long> {
    private String name;
    private String email;
    private String password;
}
