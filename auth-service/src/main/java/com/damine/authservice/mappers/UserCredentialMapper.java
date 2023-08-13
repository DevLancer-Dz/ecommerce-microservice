package com.damine.authservice.mappers;

import com.damine.authservice.DTO.UserCredentialDto;
import com.damine.authservice.DTO.UserCredentialRequestDto;
import com.damine.authservice.models.UserCredential;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCredentialMapper {
    UserCredential from(UserCredentialRequestDto userCredentialRequestDto);

    UserCredentialDto to(UserCredential userCredential);
}
