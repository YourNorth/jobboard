package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Education;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EducationService {
    List<Education> findAll();
}
