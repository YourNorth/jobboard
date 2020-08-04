package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Subscriber;
import org.springframework.stereotype.Service;

@Service
public interface SubscriberService {
    Subscriber save(Subscriber subscriber);
}
