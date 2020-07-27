package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillService {
    List<Skill> findAll();
}
