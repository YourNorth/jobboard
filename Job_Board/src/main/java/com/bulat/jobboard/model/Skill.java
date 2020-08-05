package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Skill (programming language)
 * @author Bulat Bilalov
 * @see com.bulat.jobboard.model.BaseEntity
 * @see db.changelog/db.changelog-1.1.xml
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "skills")
public class Skill extends BaseEntity{

    /** Skill name */
    @Column(name = "name")
    private String name;
}
