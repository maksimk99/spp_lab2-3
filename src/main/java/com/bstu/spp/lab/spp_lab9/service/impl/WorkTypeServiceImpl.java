package com.bstu.spp.lab.spp_lab9.service.impl;

import com.bstu.spp.lab.spp_lab9.model.WorkType;
import com.bstu.spp.lab.spp_lab9.repository.WorkTypeRepository;
import com.bstu.spp.lab.spp_lab9.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTypeServiceImpl implements WorkTypeService {

    private WorkTypeRepository workTypeRepository;

    @Autowired
    public WorkTypeServiceImpl(final WorkTypeRepository workTypeRepository) {
        this.workTypeRepository = workTypeRepository;
    }

    public List<WorkType> findAll() {
        return (List<WorkType>) workTypeRepository.findAll();
    }

    public WorkType findById(final Integer workTypeId) {
        return workTypeRepository.findById(workTypeId).get();
    }

    public Integer add(final String workTypeName) {
        WorkType workType = new WorkType();
        workType.setWorkTypeName(workTypeName);
        return workTypeRepository.save(workType).getWorkTypeId();
    }

    public void delete(final Integer workTypeId) {
        workTypeRepository.deleteById(workTypeId);
    }
}
