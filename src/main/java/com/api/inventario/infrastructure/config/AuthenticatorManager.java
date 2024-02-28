package com.api.inventario.infrastructure.config;

import com.api.inventario.infrastructure.security.service.UserManagementService;
import com.api.inventario.domain.model.security.SecurityUser;
import com.api.inventario.infrastructure.security.CustomAuthentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatorManager extends DaoAuthenticationProvider {

    public AuthenticatorManager(UserManagementService userManagementService, PasswordEncoder passwordEncoder) {
        setUserDetailsService(userManagementService);
        setPasswordEncoder(passwordEncoder);

    }
    @Override
    public Authentication createSuccessAuthentication(Object principal, Authentication authentication, UserDetails user) {
        UsernamePasswordAuthenticationToken successAuthentication =
                (UsernamePasswordAuthenticationToken) super.createSuccessAuthentication(principal, authentication, user);
        SecurityUser securityUser = (SecurityUser) user;
        return new CustomAuthentication(successAuthentication, securityUser.userPrincipal().getUserId().toString());
    }
}
