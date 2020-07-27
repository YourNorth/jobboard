package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Feedback;
import org.springframework.stereotype.Service;

@Service
public interface FeedbackService {
    Feedback save(Feedback feedback);
}
