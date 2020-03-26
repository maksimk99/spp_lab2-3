package com.bstu.spp.lab.spp_lab9.service;

import com.bstu.spp.lab.spp_lab9.model.WorkType;

import java.util.List;

public interface WorkTypeService {

    List<WorkType> findAll();

    WorkType findById(Integer workTypeId);

    Integer add(String workTypeName);

    void delete(Integer workTypeId);
}
