package com.api.inventario.infrastructure.security.service;

import com.api.inventario.domain.model.security.SecurityUser;
import com.api.inventario.infrastructure.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManagementService implements UserDetailsService {

  private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username).map(SecurityUser::new)
                .orElseThrow(() -> new RuntimeException("UserPrincipal not found"));


    }
}
