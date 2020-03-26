package com.bstu.spp.lab.spp_lab9.service.impl;

import com.bstu.spp.lab.spp_lab9.exception.JobAlreadyOccupied;
import com.bstu.spp.lab.spp_lab9.exception.WorkerAlreadyHasJob;
import com.bstu.spp.lab.spp_lab9.model.Job;
import com.bstu.spp.lab.spp_lab9.model.User;
import com.bstu.spp.lab.spp_lab9.repository.UserRepository;
import com.bstu.spp.lab.spp_lab9.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class WorkerServiceImpl implements WorkerService {

    private UserRepository userRepository;
    private JobServiceImpl jobService;

    @Autowired
    public WorkerServiceImpl(final UserRepository userRepository, final JobServiceImpl jobService) {
        this.userRepository = userRepository;
        this.jobService = jobService;
    }

    public User findById(final Integer workerId) {
        return userRepository.findById(workerId).get();
    }

    public void addJob(final Integer workerId, final Integer jobId) {
        Job job = new Job();
        job.setJobId(jobId);
        User user = userRepository.findById(workerId).get();
        if (Objects.nonNull(user.getJob())) {
            throw new WorkerAlreadyHasJob("Can't get job. Worker already has job with id = " + user.getJob().getJobId());
        }
        user.setJob(job);
        if (jobService.increaseOccupiedCount(jobId)) {
            userRepository.save(user);
        } else {
            throw new JobAlreadyOccupied("Can't get job with id = " + jobId + ", all places are occupied.");
        }
    }

    public void deleteJob(final Integer workerId) {
        User user = userRepository.findById(workerId).get();
        Job job = user.getJob();
        if (Objects.nonNull(job)) {
            user.setJob(null);
            userRepository.save(user);
            jobService.decreaseOccupiedCount(job.getJobId());
        }
    }
}
