package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {
    List<Country> findAll();
}
