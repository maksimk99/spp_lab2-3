package com.bstu.spp.lab.spp_lab9.service;

import com.bstu.spp.lab.spp_lab9.model.WorkType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class WorkTypeServiceTest {

    @Autowired
    WorkTypeService workTypeService;

    @Test
    void findById() {
        Integer workTypeId = 2;
        WorkType workType = workTypeService.findById(workTypeId);
        assertNotNull(workType);
        assertEquals(workTypeId, workType.getWorkTypeId());
        assertEquals("painting", workType.getWorkTypeName());
    }

    @Test
    void add() {
        String workTypeName = "wallpapering";
        Integer workTypeId = workTypeService.add(workTypeName);
        assertNotNull(workTypeId);
        WorkType workType = workTypeService.findById(workTypeId);
        assertNotNull(workType);
        assertEquals(workTypeName, workType.getWorkTypeName());
    }

    @Test
    void delete() {
        Integer workTypeId = workTypeService.add("workTypeName");
        assertNotNull(workTypeId);
        assertNotNull(workTypeService.findById(workTypeId));
        workTypeService.delete(workTypeId);
        assertThrows(NoSuchElementException.class, () -> workTypeService.findById(workTypeId));
    }
}