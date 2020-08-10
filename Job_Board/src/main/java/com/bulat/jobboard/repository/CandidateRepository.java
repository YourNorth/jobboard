package com.bulat.jobboard.repository;

import com.bulat.jobboard.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findById(Long id);
    List<Candidate> findByUserId(Long user_id);
}
