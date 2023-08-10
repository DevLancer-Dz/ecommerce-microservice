package com.damine.productservice.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto extends AbstractDto<Long>{
    @NotNull(message = "this filed is required")
    @NotBlank(message = "this filed is required")
    @Length(message = "the name must have at least 3 character",min = 3)
    String name ;
    String description ;

}
