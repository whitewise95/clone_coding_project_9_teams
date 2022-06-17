package com.clonecodingproject.clone_coding_project_9_teams.domain;

import com.clonecodingproject.clone_coding_project_9_teams.domain.resultType.Timestamped;
import lombok.*;

import javax.persistence.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String price;

    @OneToMany
    @JoinColumn(name = "imageUrl_id")
    private List<ImageUrl> imageUrls;
}
