package com.api.securityGateway.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;

@Component
public class RateLimiterFilter extends OncePerRequestFilter {

    private final Bucket bucket;

    public RateLimiterFilter() {
        // Set rate limit to 5 requests per minute
        Bandwidth limit = Bandwidth.classic(5, Refill.greedy(5, Duration.ofMinutes(1)));
        this.bucket = Bucket4j.builder().addLimit(limit).build();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Exclude Swagger UI and API docs paths from rate limiting
        if (request.getRequestURI().startsWith("/swagger-ui/") || request.getRequestURI().startsWith("/v3/api-docs")) {
            filterChain.doFilter(request, response); // Allow Swagger UI and docs without rate limit
            return;
        }

        // Check if bucket has tokens available
        if (bucket.tryConsume(1)) {
            // If allowed, continue to the next filter or controller
            filterChain.doFilter(request, response);
        } else {
            // If rate limit exceeded, return a "Too Many Requests" status
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            response.getWriter().write("Too Many Requests - Rate limit exceeded");
        }
    }
}
