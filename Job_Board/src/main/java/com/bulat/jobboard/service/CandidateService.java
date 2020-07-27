package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CandidateService {
    List<Candidate> findAll();
    Optional<Candidate> findById(Long id);
}
