package com.bstu.spp.lab.spp_lab9.service;

import com.bstu.spp.lab.spp_lab9.model.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityServiceTest {

    @Autowired
    CityService cityService;

    @Test
    void findById() {
        Integer cityId = 1;
        City city = cityService.findById(cityId);
        assertNotNull(city);
        assertEquals(cityId, city.getCityId());
        assertEquals("Brest", city.getCityName());
    }

    @Test
    void add() {
        String cityName = "Minsk";
        Integer cityId = cityService.add(cityName);
        assertNotNull(cityId);
        City city = cityService.findById(cityId);
        assertNotNull(city);
        assertEquals(cityName, city.getCityName());
    }

    @Test
    void delete() {
        Integer cityId = cityService.add("cityName");
        assertNotNull(cityId);
        assertNotNull(cityService.findById(cityId));
        cityService.delete(cityId);
        assertThrows(NoSuchElementException.class, () -> cityService.findById(cityId));
    }
}