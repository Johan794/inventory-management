package com.api.inventario.domain.model.security;

import com.api.inventario.application.constant.RoleScope;
import com.api.inventario.domain.model.Role;
import com.api.inventario.domain.model.UserPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
public record SecurityUser(UserPrincipal userPrincipal) implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(userPrincipal).map(UserPrincipal::getRole).map(Role::getScope).map(RoleScope::getScope).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userPrincipal.getPassword();
    }

    @Override
    public String getUsername() {
        return userPrincipal.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




}
