package com.bstu.spp.lab.spp_lab9.service;

import com.bstu.spp.lab.spp_lab9.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class WorkerServiceTest {

    @Autowired
    WorkerService workerService;

    @Test
    void findBuId() {
        Integer userId = 1;
        User user = workerService.findById(userId);
        assertNotNull(user);
        assertEquals(userId, user.getUserId());
        assertEquals("Roma", user.getFirstName());
        assertEquals(23, user.getAge());
    }

    @Test
    void addJob() {
        Integer workerId = 2;
        Integer newJobId = 2;
        workerService.addJob(workerId, newJobId);
        User updatedUser = workerService.findById(workerId);
        assertNotNull(updatedUser);
        assertEquals(newJobId, updatedUser.getJob().getJobId());
    }

    @Test
    void deleteJob() {
        Integer workerId = 1;
        workerService.deleteJob(workerId);
        User updatedUser = workerService.findById(workerId);
        assertNotNull(updatedUser);
        assertNull(updatedUser.getJob());
    }
}