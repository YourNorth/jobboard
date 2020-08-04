package com.bulat.jobboard.service.impl;

import com.bulat.jobboard.model.Language;
import com.bulat.jobboard.repository.LanguageRepository;
import com.bulat.jobboard.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Optional<Language> findByName(String name) {
        return languageRepository.findByName(name);
    }
}
