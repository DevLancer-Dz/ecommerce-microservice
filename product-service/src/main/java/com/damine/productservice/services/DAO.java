package com.damine.productservice.services;

import com.damine.productservice.DTO.AbstractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Collection;

public interface DAO<DTO extends AbstractDto<ID>, ID extends Serializable> {
    DTO save(DTO dto);

    DTO findById(ID id);


    DTO update(DTO dto);

    void deleteByID(ID id);

    Collection<DTO> findAll();

    Page<DTO> findAll(Pageable pageable);


}
