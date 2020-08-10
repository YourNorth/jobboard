package com.bulat.jobboard.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "blogs")
public class Blog extends BaseEntity{

    @Column(name = "day")
    private Integer day;

    @Column(name = "month")
    @Enumerated(EnumType.STRING)
    private Month month;

    /** Link to prepared images */
    @Column(name = "link_img")
    private String link_img;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="topic_id")
    private Topic topic;

    /** Blog description */
    @Column(name = "description", length = 3000)
    private String description;
}
