package com.bank.productos_api.config;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;


@Component
public class TrackingFilter extends OncePerRequestFilter {

    private static final String TRACKING_HEADER = "X-Tracking-Id";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String trackingId = request.getHeader(TRACKING_HEADER);

        if (trackingId == null) {
            MDC.put("X-Tracking-Id", trackingId);
        }

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove("X-Tracking-Id");
        }
    }
}
