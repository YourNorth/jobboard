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
@Table(name = "country")

/**
 * @see This model is created in classpath:/db/changelog/db.changelog-1.3.xml
 */

public class Country extends BaseEntity{

    @Column(name = "name")
    private String name;
}
