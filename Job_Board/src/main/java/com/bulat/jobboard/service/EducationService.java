package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Education;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EducationService {
    List<Education> findAll();
    Optional<Education> findByName(String name);
}
