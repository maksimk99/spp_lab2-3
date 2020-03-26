package com.bstu.spp.lab.spp_lab9.service;

import com.bstu.spp.lab.spp_lab9.model.User;

public interface WorkerService {

    User findById(Integer workerId);

    void addJob(Integer workerId, Integer jobId);

    void deleteJob(Integer workerId);
}
