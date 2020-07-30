package com.bulat.jobboard.service.impl;

import com.bulat.jobboard.model.Company;
import com.bulat.jobboard.repository.CompanyRepository;
import com.bulat.jobboard.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> findByName(String name) {
        return companyRepository.findByName(name);
    }
}
