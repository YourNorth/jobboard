package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "skills")

/**
 * @see This model is created in classpath:/db/changelog/db.changelog-1.1.xml
 */

public class Skill extends BaseEntity{

    @Column(name = "name")
    private String name;
}
