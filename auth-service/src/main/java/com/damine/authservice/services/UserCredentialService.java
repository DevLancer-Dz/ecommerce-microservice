package com.damine.authservice.services;

import com.damine.authservice.DTO.UserCredentialDto;
import com.damine.authservice.http.request.AuthRequest;
import com.damine.authservice.http.response.UserCredentialResponse;
import com.damine.authservice.mappers.UserCredentialMapper;
import com.damine.authservice.repositories.UserCredentialRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCredentialService {

    private final UserCredentialRepository userCredentialRepository;
    private final UserCredentialMapper userCredentialMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserCredentialResponse saveUser(UserCredentialDto userCredentialRequestDto) {
        userCredentialRequestDto.setPassword(passwordEncoder.encode(userCredentialRequestDto.getPassword()));
        return userCredentialMapper.to(userCredentialRepository.save(userCredentialMapper.from(userCredentialRequestDto)));
    }

    public String generateToken(AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getName());
        } else {
            throw new RuntimeException("invalid authentication");
        }
    }

    public Jws<Claims> validateToken(String token) {
        return jwtService.validateToken(token);
    }
}
