package com.damine.authservice.controllers;

import com.damine.authservice.DTO.UserCredentialDto;
import com.damine.authservice.http.request.AuthRequest;
import com.damine.authservice.http.response.UserCredentialResponse;
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
    public ResponseEntity<UserCredentialResponse> save(@Valid @RequestBody UserCredentialDto userCredentialDto) {
        return new ResponseEntity<>(userCredentialService.saveUser(userCredentialDto), HttpStatus.CREATED);
    }

    @PostMapping("token")
    public String getToken(@Valid @RequestBody AuthRequest authRequest) {
        return userCredentialService.generateToken(authRequest);
    }

    @GetMapping("validate")
    public ResponseEntity<Jws<Claims>> validateToken(@RequestParam("token") String token) {
        return new ResponseEntity<>(userCredentialService.validateToken(token), HttpStatus.ACCEPTED);
    }

}
