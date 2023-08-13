package com.damine.authservice.controllers;

import com.damine.authservice.DTO.UserCredentialDto;
import com.damine.authservice.DTO.UserCredentialRequestDto;
import com.damine.authservice.services.UserCredentialService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class UserCredentialController {
    private final UserCredentialService userCredentialService;

    @PostMapping("register")
    public ResponseEntity<UserCredentialDto> save(@Valid @RequestBody UserCredentialRequestDto userCredentialDto) {
        return new ResponseEntity<>(userCredentialService.saveUser(userCredentialDto), HttpStatus.CREATED);
    }

    @GetMapping("token")
    public String getToken(UserCredentialDto userCredentialDto) {
        return userCredentialService.generateToken(userCredentialDto.getName());
    }

    @GetMapping("validate")
    public ResponseEntity<Jws<Claims>> validateToken(@RequestParam("token") String token) {
        return new ResponseEntity<>(userCredentialService.validateToken(token), HttpStatus.ACCEPTED);
    }

}
