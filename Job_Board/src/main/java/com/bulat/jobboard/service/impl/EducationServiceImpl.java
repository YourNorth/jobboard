package com.bulat.jobboard.service.impl;

import com.bulat.jobboard.model.Education;
import com.bulat.jobboard.repository.EducationRepository;
import com.bulat.jobboard.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }
}
