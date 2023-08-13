package com.damine.authservice.services;

import com.damine.authservice.DTO.UserCredentialDto;
import com.damine.authservice.DTO.UserCredentialRequestDto;
import com.damine.authservice.mappers.UserCredentialMapper;
import com.damine.authservice.repositories.UserCredentialRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCredentialService {

    private final UserCredentialRepository userCredentialRepository;
    private final UserCredentialMapper userCredentialMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public UserCredentialDto saveUser(UserCredentialRequestDto userCredentialRequestDto) {
        userCredentialRequestDto.setPassword(passwordEncoder.encode(userCredentialRequestDto.getPassword()));
        return userCredentialMapper.to(userCredentialRepository.save(userCredentialMapper.from(userCredentialRequestDto)));
    }
    public String generateToken(String userName){
        return jwtService.generateToken(userName);
    }

    public Jws<Claims> validateToken(String token){
        return jwtService.validateToken(token);
    }
}
