package com.api.inventario.infrastructure.security.service;

import com.api.inventario.infrastructure.dto.auth.JwtDto;
import com.api.inventario.infrastructure.security.CustomAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JwtService {
    private final JwtEncoder jwtEncoder;

    public JwtDto generateToken(Authentication authentication) {

        CustomAuthentication customAuthentication = (CustomAuthentication) authentication;
        Instant now = Instant.now();
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", scope)
                .claim("userId", customAuthentication.getUserId())
                .build();
        var encoderParameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(),claims);
        return JwtDto.builder()
                .role(scope)
                .token(this.jwtEncoder.encode(encoderParameters).getTokenValue()).build();
    }


}
