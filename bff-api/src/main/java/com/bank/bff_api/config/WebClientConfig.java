package com.bank.bff_api.config;

import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.filter((request, next) -> {

                    String trackingId = MDC.get("tracking-id");

                    ClientRequest newRequest = ClientRequest.from(request)
                            .header("X-Tracking-Id", trackingId
                                    != null ? trackingId : UUID.randomUUID().toString())
                    .build();
            return next.exchange(newRequest);
        }).build();
    }
}
