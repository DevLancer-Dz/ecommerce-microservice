package com.damine.authservice.mappers;

import com.damine.authservice.DTO.UserCredentialDto;
import com.damine.authservice.http.response.UserCredentialResponse;
import com.damine.authservice.models.UserCredential;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCredentialMapper {
    UserCredential from(UserCredentialDto userCredentialRequestDto);

    UserCredentialResponse to(UserCredential userCredential);
}
