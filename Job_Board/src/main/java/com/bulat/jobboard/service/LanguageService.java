package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Language;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LanguageService {
    List<Language> findAll();
}
