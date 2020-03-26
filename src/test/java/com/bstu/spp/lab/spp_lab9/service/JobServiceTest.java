package com.bstu.spp.lab.spp_lab9.service;

import com.bstu.spp.lab.spp_lab9.model.City;
import com.bstu.spp.lab.spp_lab9.model.Customer;
import com.bstu.spp.lab.spp_lab9.model.Job;
import com.bstu.spp.lab.spp_lab9.model.WorkType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobServiceTest {

    @Autowired
    JobService jobService;
    static Job job;

    @BeforeAll
    static void setup() {
        job = Job.builder().description("description").positionCount(4).price(new BigDecimal("10.00"))
                .city(City.builder().cityId(2).build())
                .workType(WorkType.builder().workTypeId(2).build())
                .customer(Customer.builder().customerId(2).build())
                .build();
    }

    @Test
    void findAll() {
        List<Job> jobList = jobService.findAll();
        assertNotNull(jobList);
        assertTrue(jobList.size() > 0);
    }

    @Test
    void findBuId() {
        Integer jobId = 1;
        Job job = jobService.findById(jobId);
        assertNotNull(job);
        assertEquals(jobId, job.getJobId());
        assertEquals("dig a trench", job.getDescription());
        assertEquals("Brest", job.getCity().getCityName());
    }

    @Test
    void add() {
        Integer jobId = jobService.add(job);
        assertNotNull(jobId);
        Job generatedJob = jobService.findById(jobId);
        assertNotNull(generatedJob);
        assertEquals(job.getDescription(), generatedJob.getDescription());
        assertEquals(job.getPrice(), generatedJob.getPrice());
        assertEquals(job.getCustomer().getCustomerId(), generatedJob.getCustomer().getCustomerId());
    }

    @Test
    void updateOccupiedCount() {
        Integer jobId = 2;
        Job jobBeforeUpdate = jobService.findById(jobId);
        assertTrue(jobService.increaseOccupiedCount(jobId));
        Job jobAfterUpdate = jobService.findById(jobId);
        assertEquals(1, jobAfterUpdate.getOccupiedCount() - jobBeforeUpdate.getOccupiedCount());
    }

    @Test
    void delete() {
        Integer generatedJobId = jobService.add(job);
        assertNotNull(generatedJobId);
        assertNotNull(jobService.findById(generatedJobId));
        jobService.delete(generatedJobId);
        assertThrows(NoSuchElementException.class, () -> jobService.findById(generatedJobId));
    }
}