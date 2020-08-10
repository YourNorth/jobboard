package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.*;

/**
 * Class that responds to the comment on the site
 * @author Bulat Bilalov
 * @version 1.0
 * @see com.bulat.jobboard.model.BaseEntity
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{

    /** The name of the comment */
    @Column(name = "first_name")
    private String firstName;

    /** The surname of the comment */
    @Column(name = "last_name")
    private String lastName;

    /** Link to prepared images */
    @Column(name = "link_img")
    private String link_img;

    /** Comment description */
    @Column(name = "description", length = 3000)
    private String description;

    /** User who left a comment */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;
}
