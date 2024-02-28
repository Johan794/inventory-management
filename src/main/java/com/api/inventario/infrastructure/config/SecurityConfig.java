package com.api.inventario.infrastructure.config;


import com.api.inventario.infrastructure.repository.RoleRepository;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class SecurityConfig {
    private final AuthenticatorManager authenticatorManager;


    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(authenticatorManager);
    }

    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher("/api/**")
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest()
                        .hasRole("ADMIN")

                )
                .httpBasic(withDefaults());

        http.securityMatcher("/api/inventory/**")
         .authorizeHttpRequests(authorize -> authorize
                .anyRequest()
                .hasRole("SUPERVISOR")

        ).httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    public JwtEncoder jwtEncoder() {
        String secret = "longenoughsecrettotestjwtencrypt";
        return new NimbusJwtEncoder(new ImmutableSecret<>(secret.getBytes()));
    }
}
