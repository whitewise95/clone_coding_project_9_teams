package com.clonecodingproject.clone_coding_project_9_teams.service;

import com.clonecodingproject.clone_coding_project_9_teams.domain.Likes;
import com.clonecodingproject.clone_coding_project_9_teams.domain.Post;
import com.clonecodingproject.clone_coding_project_9_teams.domain.Users;
import com.clonecodingproject.clone_coding_project_9_teams.repository.LikeRepository;
import com.clonecodingproject.clone_coding_project_9_teams.repository.PostRepository;
import com.clonecodingproject.clone_coding_project_9_teams.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;

    @Transactional
    public void uplike(Long postId){
        Long userId = 1L; //테스트용
        Users users = userRepository.findById(userId).orElseThrow(
                ()->new NullPointerException("해당 ID가 존재하지 않습니다.")
       );
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );

        if (likeRepository.findByUserAndPost(users, post)==null){
            Likes likes = new Likes(users, post, null);
            likes.setHeart("like");
            likeRepository.save(likes);
        } else {
            Likes likes = likeRepository.getLikesByUserAndPost(users, post);
            likeRepository.delete(likes);
        }

        int count = likeRepository.findAllByPost(post).size();
        post.setLikeCount(count);
        postRepository.save(post);

    }

    public boolean checkLike( Long postId){
        Users users = userRepository.findById(new Users("test").getId()).orElseThrow(
                ()->new NullPointerException("해당 ID가 존재하지 않습니다.")
        );
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );
        if (likeRepository.findByUserAndPost(users, post)==null){
            return true;
        }else {
            return false;
        }
    }
}
