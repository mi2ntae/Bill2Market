package com.example.demo.model.client;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
public class ClientPrincipal implements UserDetails {

    private final String clientId;
    private final String password;
    private final Role role;
    private final Collection<GrantedAuthority> authorities;

    public static ClientPrincipal create(Client client) {
        return new ClientPrincipal(
                client.getClient_id(),
                client.getPassword(),
                Role.USER,
                Collections.singletonList(new SimpleGrantedAuthority(Role.USER.getKey())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.clientId;
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
