package com.bank.bff_api.controller;

import com.bank.bff_api.dto.ResponseDTO;
import com.bank.bff_api.service.BffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/bff")
public class BffController {

    private final BffService bffService;

    public BffController(BffService bffService) {
        this.bffService = bffService;
    }

    @GetMapping("/datos")
    public Mono<ResponseDTO> getData(@RequestParam String codigoEncriptado) {
        String trakingId = UUID.randomUUID().toString();
        return bffService.obtenerDatosCompletos(codigoEncriptado, trakingId);
    }
}
