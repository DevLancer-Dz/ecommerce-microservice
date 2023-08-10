package com.damine.productservice.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface AbstractMapper<ENTITY, DTO> {

    ENTITY from(DTO dto);

    DTO to(ENTITY entity);

    default Collection<DTO> to(Collection<ENTITY> entities) {
        return entities.stream().map(this::to).toList();
    }

    default Collection<ENTITY> from(Collection<DTO> dtos) {
        return dtos.stream().map(this::from).toList();
    }

    default Page<DTO> to(Page<ENTITY> entityPage) {
        if (entityPage == null) {
            throw new IllegalArgumentException("Input entityPage cannot be null.");
        }
        List<DTO> dtoList = entityPage.getContent().stream()
                .map(this::to)
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }

    default Page<ENTITY> from(Page<DTO> entityPage) {
        if (entityPage == null) {
            throw new IllegalArgumentException("Input entityPage cannot be null.");
        }
        List<ENTITY> dtoList = entityPage.getContent().stream()
                .map(this::from)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }

}
