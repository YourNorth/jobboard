package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    List<Company> findAll();
    List<Company> findByName(String name);
}
