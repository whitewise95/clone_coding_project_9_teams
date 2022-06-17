package com.clonecodingproject.clone_coding_project_9_teams.domain;

import com.clonecodingproject.clone_coding_project_9_teams.domain.resultType.Timestamped;
import com.clonecodingproject.clone_coding_project_9_teams.dto.SignupDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String region;

    public User(SignupDto signupDto, String password) {
        this.username = signupDto.getUsername();
        this.nickname = signupDto.getNickname();
        this.password = password;
        this.region = signupDto.getRegion();
    }

    public User(String test, String test1, String test2, String test3) {
        this.username = test;
        this.password = test1;
        this.nickname = test2;
        this.region = test3;
    }
}
