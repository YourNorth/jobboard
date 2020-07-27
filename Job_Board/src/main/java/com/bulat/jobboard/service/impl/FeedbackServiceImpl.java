package com.bulat.jobboard.service.impl;

import com.bulat.jobboard.model.Feedback;
import com.bulat.jobboard.repository.FeedbackRepository;
import com.bulat.jobboard.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback save(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
}
