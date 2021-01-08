package com.bulat.jobboard.service.impl;

import com.bulat.jobboard.model.Company;
import com.bulat.jobboard.repository.CompanyRepository;
import com.bulat.jobboard.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.restdocs.mustache.Mustache;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        List<Company> result = new ArrayList<Company>();
        companyRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Optional<Company> findByName(String name) {
        return companyRepository.findByName(name);
    }

    @Override
    public List<Company> findByUserId(Long user_id) {
        return companyRepository.findByUserId(user_id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void changeDescription(Company company, String description) {
        company.setDescription(description);
        this.save(company);
    }
}
