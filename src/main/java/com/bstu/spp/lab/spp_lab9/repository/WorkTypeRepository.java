package com.bstu.spp.lab.spp_lab9.repository;

import com.bstu.spp.lab.spp_lab9.model.WorkType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTypeRepository extends CrudRepository<WorkType, Integer> {
}
