package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.*;

/**
 * Entity in charge of blogs
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
@Table(name = "blogs")
public class Blog extends BaseEntity{

    /** Blog creation day */
    @Column(name = "day")
    private Integer day;

    /** Month of blog creation */
    @Column(name = "month")
    @Enumerated(EnumType.STRING)
    private Month month;

    /** Link to prepared images */
    @Column(name = "link_img")
    private String link_img;

    /** The user who created the blog */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    /** Blog Title */
    @Column(name = "name")
    private String name;

    /** Blog theme */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="topic_id")
    private Topic topic;

    /** Blog description */
    @Column(name = "description", length = 3000)
    private String description;
}
