package com.vdobrikov.training.mdclogtraining;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class RequestIdFilter extends OncePerRequestFilter {
    private static final String HEADER_REQUEST_ID_NAME = "x-app-request-id";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestId = request.getHeader(HEADER_REQUEST_ID_NAME);
        if (requestId == null) {
            requestId = UUID.randomUUID().toString().replace("-", "");
        }
        response.setHeader(HEADER_REQUEST_ID_NAME, requestId);

        try {
            MDC.put(HEADER_REQUEST_ID_NAME, requestId);
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(HEADER_REQUEST_ID_NAME);
        }
    }
}
