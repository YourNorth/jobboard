package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for company feedback
 * @author Bulat Bilalov
 * @version 1.0
 * @see com.bulat.jobboard.model.BaseEntity
 * @see db.changelog/db.changelog-1.5.xml
 */
@EqualsAndHashCode(callSuper = false)
@Entity(name = "feedbackForCompanies")
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackForCompany extends BaseEntity{

    /** Unique identifier for the candidate */
    @Column(name = "candidate_id")
    private Long candidate_id;

    /** The name of the candidate */
    @Column(name = "name")
    private String name;

    /** Contact information (mail) */
    @Column(name = "contact")
    private String contact;

    /** Company name */
    @Column(name = "company_name")
    private String company_name;

    /** Application letter */
    @Column(name = "cover_letter")
    private String cover_letter;
}
