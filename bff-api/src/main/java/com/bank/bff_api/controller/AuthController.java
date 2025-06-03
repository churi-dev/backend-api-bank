package com.bank.bff_api.controller;

import com.bank.bff_api.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    @PostMapping("/login")
    public Mono<ResponseEntity<Map<String, String >>>
    login(@RequestBody Map<String, String> credenciales) {
        String usuario = credenciales.get("username");
        String clave = credenciales.get("password");

        if ("admin".equals(usuario) && "admin".equals(clave)) {
            String token = tokenService.generateToken(usuario);
            return Mono.just(ResponseEntity.ok(Map.of("token", token)));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
        }
    }
}
