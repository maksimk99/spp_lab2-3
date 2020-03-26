package com.bstu.spp.lab.spp_lab9.repository;

import com.bstu.spp.lab.spp_lab9.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String userName);

    List<User> findAll();
}
