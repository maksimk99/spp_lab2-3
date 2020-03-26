package com.bstu.spp.lab.spp_lab9.service.impl;

import com.bstu.spp.lab.spp_lab9.model.Job;
import com.bstu.spp.lab.spp_lab9.repository.JobRepository;
import com.bstu.spp.lab.spp_lab9.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(final JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Job findById(final Integer jobId) {
        return jobRepository.findById(jobId).get();
    }

    public Integer add(final Job job) {
        job.setOccupiedCount(0);
        return jobRepository.save(job).getJobId();
    }

    public void update(final Job job) {
        jobRepository.save(job);
    }

    public boolean increaseOccupiedCount(final Integer jobId) {
        Job job = jobRepository.findById(jobId).get();
        Integer occupiedCount = job.getOccupiedCount();
        if (occupiedCount < job.getPositionCount()) {
            job.setOccupiedCount(job.getOccupiedCount() + 1);
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    public void decreaseOccupiedCount(final Integer jobId) {
        Job job = jobRepository.findById(jobId).get();
        job.setOccupiedCount(job.getOccupiedCount() - 1);
        jobRepository.save(job);
    }

    public void delete(final Integer jobId) {
        jobRepository.deleteById(jobId);
    }
}
