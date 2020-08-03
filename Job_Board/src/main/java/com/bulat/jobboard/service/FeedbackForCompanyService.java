package com.bulat.jobboard.service;

import com.bulat.jobboard.model.FeedbackForCompany;
import org.springframework.stereotype.Service;

@Service
public interface FeedbackForCompanyService {
    FeedbackForCompany save(FeedbackForCompany feedbackForCompany);
}
