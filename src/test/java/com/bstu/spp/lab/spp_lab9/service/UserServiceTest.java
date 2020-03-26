package com.bstu.spp.lab.spp_lab9.service;

import com.bstu.spp.lab.spp_lab9.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void getUserByUserName() {
        String userName = "user";
        User user = userService.getUserByUserName(userName);
        assertNotNull(user);
        assertEquals(userName, user.getUserName());
    }

    @Test
    void addUser() {
        User user = new User(null, "Oleg", "Petrov",
                25, "oleg96", "password", null, null);
        User newUser = userService.addUser(user);
        assertNotNull(newUser);
        assertEquals(user.getUserName(), newUser.getUserName());
        assertEquals(user.getAge(), newUser.getAge());
        assertEquals(user.getFirstName(), newUser.getFirstName());
    }
}