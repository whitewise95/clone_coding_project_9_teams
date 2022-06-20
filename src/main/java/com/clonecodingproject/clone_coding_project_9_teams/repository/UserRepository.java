package com.clonecodingproject.clone_coding_project_9_teams.repository;

import com.clonecodingproject.clone_coding_project_9_teams.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    boolean existsByUsername(String username);
    boolean existsByNickname(String nickname);
}
