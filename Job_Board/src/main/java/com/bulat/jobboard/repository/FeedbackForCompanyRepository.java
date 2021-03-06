package com.bulat.jobboard.repository;

import com.bulat.jobboard.model.FeedbackForCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackForCompanyRepository extends JpaRepository<FeedbackForCompany, Long> {
}
