package com.bstu.spp.lab.spp_lab9.repository;

import com.bstu.spp.lab.spp_lab9.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {

    List<Job> findAll();
}
