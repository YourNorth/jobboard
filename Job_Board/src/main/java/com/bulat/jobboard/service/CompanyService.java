package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CompanyService {
    List<Company> findAll();
    Optional<Company> findByName(String name);
    Company save(Company company);
}
