package com.bstu.spp.lab.spp_lab9.service.impl;

import com.bstu.spp.lab.spp_lab9.model.User;
import com.bstu.spp.lab.spp_lab9.model.security.UserRole;
import com.bstu.spp.lab.spp_lab9.repository.UserRepository;
import com.bstu.spp.lab.spp_lab9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUserName(final String userName) {
        return userRepository.findByUserName(userName);
    }

    public User addUser(final User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setUserRoles(getUserRole());
        return userRepository.save(user);
    }

    private Set<UserRole> getUserRole() {
        HashSet<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRoleId(1);
        userRole.setRole("USER");
        userRoles.add(userRole);
        return userRoles;
    }
}
