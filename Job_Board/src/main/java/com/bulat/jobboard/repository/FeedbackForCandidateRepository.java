package com.bulat.jobboard.repository;

import com.bulat.jobboard.model.FeedbackForCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackForCandidateRepository extends JpaRepository<FeedbackForCandidate, Long> {
}
