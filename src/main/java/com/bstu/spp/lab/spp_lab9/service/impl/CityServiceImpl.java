package com.bstu.spp.lab.spp_lab9.service.impl;

import com.bstu.spp.lab.spp_lab9.model.City;
import com.bstu.spp.lab.spp_lab9.repository.CityRepository;
import com.bstu.spp.lab.spp_lab9.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll() {
        return (List<City>) cityRepository.findAll();
    }

    public City findById(final Integer cityId) {
        return cityRepository.findById(cityId).get();
    }

    public Integer add(final String cityName) {
        City city = new City();
        city.setCityName(cityName);
        return cityRepository.save(city).getCityId();
    }

    public void delete(final Integer cityId) {
        cityRepository.deleteById(cityId);
    }
}
