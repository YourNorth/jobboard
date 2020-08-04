package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Language;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LanguageService {
    List<Language> findAll();
    Optional<Language> findByName(String name);
}
