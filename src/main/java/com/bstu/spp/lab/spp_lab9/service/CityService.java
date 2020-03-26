package com.bstu.spp.lab.spp_lab9.service;

import com.bstu.spp.lab.spp_lab9.model.City;

import java.util.List;

public interface CityService {

    List<City> findAll();

    City findById(Integer cityId);

    Integer add(String cityName);

    void delete(Integer cityId);
}
