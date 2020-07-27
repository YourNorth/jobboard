package com.bulat.jobboard.service.impl;

import com.bulat.jobboard.model.Skill;
import com.bulat.jobboard.repository.SkillRepository;
import com.bulat.jobboard.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }
}
