package com.damine.authservice.controllers;

import com.damine.authservice.DTO.UserCredentialDto;
import com.damine.authservice.DTO.UserCredentialRequestDto;
import com.damine.authservice.services.UserCredentialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class UserCredentialController {
    private final UserCredentialService userCredentialService;

    @PostMapping("register")
    public ResponseEntity<UserCredentialDto> save(@Valid @RequestBody UserCredentialRequestDto userCredentialDto) {
        return new ResponseEntity<>(userCredentialService.saveUser(userCredentialDto), HttpStatus.CREATED);
    }

}
