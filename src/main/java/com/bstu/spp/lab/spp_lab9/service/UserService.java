package com.bstu.spp.lab.spp_lab9.service;

import com.bstu.spp.lab.spp_lab9.model.User;

public interface UserService {

    User getUserByUserName(String userName);

    User addUser(User user);
}
