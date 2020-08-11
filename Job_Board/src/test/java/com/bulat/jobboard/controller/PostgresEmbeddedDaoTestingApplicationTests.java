package com.bulat.jobboard.controller;

import com.bulat.jobboard.config.DatabaseConfig;
import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.repository.CandidateRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class})
//@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:TestData.sql")
public class PostgresEmbeddedDaoTestingApplicationTests {

    private final CandidateRepository candidateRepository;

    @Autowired
    public PostgresEmbeddedDaoTestingApplicationTests(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Test
    @Transactional
    public void contextLoads() {

        candidateRepository.save(new Candidate().builder().email("bulat@gmail.com").build());

        Assert.assertTrue(candidateRepository.findById(1L) != null);
    }
}
