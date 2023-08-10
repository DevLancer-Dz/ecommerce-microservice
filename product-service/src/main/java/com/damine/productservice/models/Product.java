package com.damine.productservice.models;

import jakarta.persistence.Entity;
;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode (callSuper = true)
public class Product extends AbstractEntity<Long> {

    private String name;
    private String description;
}
