package com.clonecodingproject.clone_coding_project_9_teams.repository;

import com.clonecodingproject.clone_coding_project_9_teams.domain.Likes;
import com.clonecodingproject.clone_coding_project_9_teams.domain.Post;
import com.clonecodingproject.clone_coding_project_9_teams.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository <Likes, Long> {
    Likes findByUserAndPost(User user, Post post);
    Likes findAllByPost(Post post);
    Likes getLikesByUserAndPost(User user, Post post);

}
