package com.damine.authservice.mappers;

import com.damine.authservice.DTO.UserCredentialDto;
import com.damine.authservice.models.UserCredential;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCredentialMapper {
    UserCredential from(UserCredentialDto userCredentialDto);

    UserCredentialDto to(UserCredential userCredential);
}
