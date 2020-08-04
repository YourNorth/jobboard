package com.bulat.jobboard.service.impl;

import com.bulat.jobboard.model.Subscriber;
import com.bulat.jobboard.repository.SubscriberRepository;
import com.bulat.jobboard.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    private final SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberServiceImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public Subscriber save(Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    @Override
    public Optional<Subscriber> findByEmail(String email) {
        return subscriberRepository.findByEmail(email);
    }
}
