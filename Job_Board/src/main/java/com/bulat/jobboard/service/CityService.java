package com.bulat.jobboard.service;

import com.bulat.jobboard.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    List<City> findAll();
}
