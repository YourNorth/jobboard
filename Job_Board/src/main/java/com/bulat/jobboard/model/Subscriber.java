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
@Table(name = "subscribers")

/**
 * @see This model is created in classpath:/db/changelog/db.changelog-1.5.xml
 */

public class Subscriber extends BaseEntity{

    @Column(name = "email")
    private String email;
}
