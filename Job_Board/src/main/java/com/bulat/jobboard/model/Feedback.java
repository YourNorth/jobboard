package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The essence of feedback for the site
 * @author Bulat Bilalov
 * @version 1.0
 * @see com.bulat.jobboard.model.BaseEntity
 * @see db.changelog/db.changelog-1.3.xml
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "feedbacks")
public class Feedback extends BaseEntity{

    /** Username of the user who left feedback */
    @Column(name = "name")
    private String name;

    /** Feedback message */
    @Column(name = "message")
    private String message;

    /** User contact (mail) */
    @Column(name = "email")
    private String email;

    /** User role */
    @Column(name = "subject")
    private String subject;
}
