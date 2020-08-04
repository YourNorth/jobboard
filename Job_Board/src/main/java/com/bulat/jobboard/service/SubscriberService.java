package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Subscriber;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SubscriberService {
    Subscriber save(Subscriber subscriber);
    Optional<Subscriber> findByEmail(String email);
}
