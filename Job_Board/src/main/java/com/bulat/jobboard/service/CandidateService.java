package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CandidateService {
    List<Candidate> findAll();
}
