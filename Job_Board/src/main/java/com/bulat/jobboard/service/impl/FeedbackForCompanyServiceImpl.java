package com.bulat.jobboard.service.impl;

import com.bulat.jobboard.model.FeedbackForCompany;
import com.bulat.jobboard.repository.FeedbackForCompanyRepository;
import com.bulat.jobboard.service.FeedbackForCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackForCompanyServiceImpl implements FeedbackForCompanyService {

    private final FeedbackForCompanyRepository feedbackForCompanyRepository;

    @Autowired
    public FeedbackForCompanyServiceImpl(FeedbackForCompanyRepository feedbackForCompanyRepository) {
        this.feedbackForCompanyRepository = feedbackForCompanyRepository;
    }

    @Override
    public FeedbackForCompany save(FeedbackForCompany feedbackForCompany) {
        return feedbackForCompanyRepository.save(feedbackForCompany);
    }
}
