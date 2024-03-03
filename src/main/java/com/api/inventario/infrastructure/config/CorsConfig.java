package com.api.inventario.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {
    @Value("${cors.allowed.origin}")
    private String allowedOrigin;

    @Value("${cors.allowed.method}")
    private String allowedMethod;

    @Value("${cors.allowed.header}")
    private String allowedHeader;

    @Value("${cors.allowed.origin.pattern}")
    private String allowedOriginPattern;

    @Value("${cors.source.pattern}")
    private String sourcePattern;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin(allowedOrigin);
        configuration.addAllowedMethod(allowedMethod);
        configuration.addAllowedHeader(allowedHeader);
        configuration.addAllowedOriginPattern(allowedOriginPattern);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(sourcePattern, configuration);
        return source;
    }
}
