package com.damine.productservice.DTO;


import lombok.*;

import java.io.Serializable;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class AbstractDto<ID extends Serializable>   implements Serializable{

    private ID id ;

    private Date createdAt;

    private Date updatedAt;
}
