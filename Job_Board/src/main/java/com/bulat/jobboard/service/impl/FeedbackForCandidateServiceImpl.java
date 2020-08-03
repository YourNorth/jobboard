package com.bulat.jobboard.service.impl;

import com.bulat.jobboard.model.FeedbackForCandidate;
import com.bulat.jobboard.repository.FeedbackForCandidateRepository;
import com.bulat.jobboard.service.FeedbackForCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackForCandidateServiceImpl implements FeedbackForCandidateService {

    private final FeedbackForCandidateRepository feedbackForCandidateRepository;

    @Autowired
    public FeedbackForCandidateServiceImpl(FeedbackForCandidateRepository feedbackForCandidateRepository) {
        this.feedbackForCandidateRepository = feedbackForCandidateRepository;
    }

    @Override
    public FeedbackForCandidate save(FeedbackForCandidate feedback) {
        return feedbackForCandidateRepository.save(feedback);
    }
}
