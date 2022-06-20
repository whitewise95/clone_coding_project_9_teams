package com.clonecodingproject.clone_coding_project_9_teams.repository;

import com.clonecodingproject.clone_coding_project_9_teams.domain.Likes;
import com.clonecodingproject.clone_coding_project_9_teams.domain.Post;
import com.clonecodingproject.clone_coding_project_9_teams.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository <Likes, Long> {
    Likes findByUserAndPost(Users users, Post post);
    List<Likes> findAllByPost(Post post);
    Likes getLikesByUserAndPost(Users users, Post post);

}
