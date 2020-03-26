package com.bstu.spp.lab.spp_lab9.model.security;

import com.bstu.spp.lab.spp_lab9.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetailsFactory {
    public static CustomUserDetails createCustomUserDetails(final User user) {
        Collection<? extends GrantedAuthority> grantedAuthorities = user.getUserRoles().stream().map(userRole ->
                new SimpleGrantedAuthority(userRole.getRole())).collect(Collectors.toList());
        return new CustomUserDetails()
                .setUserId(user.getUserId())
                .setUserName(user.getUserName())
                .setPassword(user.getPassword())
                .setGrantedAuthorities(grantedAuthorities);
    }
}
