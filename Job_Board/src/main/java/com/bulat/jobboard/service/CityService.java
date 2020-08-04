package com.bulat.jobboard.service;

import com.bulat.jobboard.model.City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CityService {
    List<City> findAll();
    Optional<City> findByName(String name);
}
