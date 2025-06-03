package com.bank.bff_api.service;

import com.bank.bff_api.dto.ClienteDTO;
import com.bank.bff_api.dto.ProductoDTO;
import com.bank.bff_api.dto.ResponseDTO;
import com.bank.bff_api.util.EncriptadorUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BffService {
    private final WebClient.Builder webClientBuilder;

    public BffService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<ResponseDTO> obtenerDatosCompletos(String codigoEncriptado,
                                                   String trackingId) {
        String codigoUnico = EncriptadorUtil.desencriptar(codigoEncriptado);

        Mono<ClienteDTO> clienteMono = webClientBuilder.build()
                .get()
                //.uri("http://cliente-service:8082/clientes/" + codigoUnico)
                .uri("http://localhost:8082/clientes/" + codigoUnico)

                .header("X-Tracking-Id", trackingId)
                .retrieve()
                .bodyToMono(ClienteDTO.class);

        Mono<List<ProductoDTO>> productosMono = webClientBuilder.build()
                .get()
                //.uri("http://producto-service:8083/productos/" + codigoUnico)
                .uri("http://localhost:8083/productos/" + codigoUnico)

                .header("X-Tracking-Id", trackingId)
                .retrieve()
                .bodyToFlux(ProductoDTO.class)
                .collectList();

        return Mono.zip(clienteMono, productosMono)
                .map(tuple ->
                        new ResponseDTO(tuple.getT1(), tuple.getT2()));
    }
}
