package com.bstu.spp.lab.spp_lab9.service.impl;

import com.bstu.spp.lab.spp_lab9.model.User;
import com.bstu.spp.lab.spp_lab9.model.security.CustomUserDetailsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserServiceImpl userService;

    @Autowired
    public UserDetailsServiceImpl(final UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(userName);
        return CustomUserDetailsFactory.createCustomUserDetails(user);
    }
}
