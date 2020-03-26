package com.bstu.spp.lab.spp_lab9.service;

import com.bstu.spp.lab.spp_lab9.model.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();

    Job findById(Integer jobId);

    Integer add(Job job);

    void update(Job job);

    boolean increaseOccupiedCount(Integer jobId);

    void decreaseOccupiedCount(Integer jobId);

    void delete(Integer jobId);
}
