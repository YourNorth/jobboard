package com.bulat.jobboard.service;

import com.bulat.jobboard.model.FeedbackForCandidate;
import org.springframework.stereotype.Service;

@Service
public interface FeedbackForCandidateService {
    FeedbackForCandidate save(FeedbackForCandidate feedback);
}
