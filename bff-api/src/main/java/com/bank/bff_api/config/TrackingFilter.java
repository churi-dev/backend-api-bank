package com.bank.bff_api.config;

import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class TrackingFilter implements WebFilter {

    private static final String TRACKING_HEADER = "X-Tracking-Id";
    private static final String MDC_KEY = "tracking-id";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String trakingId = exchange.getRequest()
                .getHeaders()
                .getFirst(TRACKING_HEADER);

        if (trakingId == null) {
            trakingId = UUID.randomUUID().toString();
        }

        String finalTrackingId = trakingId;

        return chain.filter(exchange)
                .contextWrite(ctx -> ctx.put(MDC_KEY, finalTrackingId));
    }
}
