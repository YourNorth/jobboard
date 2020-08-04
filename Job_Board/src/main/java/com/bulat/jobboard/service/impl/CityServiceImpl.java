package com.bulat.jobboard.service.impl;

import com.bulat.jobboard.model.City;
import com.bulat.jobboard.repository.CityRepository;
import com.bulat.jobboard.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findByName(String name) {
        return cityRepository.findByName(name);
    }
}
