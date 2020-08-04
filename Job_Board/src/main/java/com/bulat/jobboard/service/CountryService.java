package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CountryService {
    List<Country> findAll();
    Optional<Country> findByName(String name);
}
