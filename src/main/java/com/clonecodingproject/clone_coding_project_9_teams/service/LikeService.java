package com.clonecodingproject.clone_coding_project_9_teams.service;

import com.clonecodingproject.clone_coding_project_9_teams.domain.Likes;
import com.clonecodingproject.clone_coding_project_9_teams.domain.Post;
import com.clonecodingproject.clone_coding_project_9_teams.domain.User;
import com.clonecodingproject.clone_coding_project_9_teams.dto.LikeDto;
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
    public void uplike(로그인유저토큰 로그인유저, Long postId){

        User user = userRepository.findById(로그인유저.getId()).orElseThrow(
                ()->new NullPointerException("해당 ID가 존재하지 않습니다.")
       );
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );

        String heart = likeRepository.getLikesByUserAndPost(user, post).getHeart();

        Likes likes = new Likes(user, post, heart);

        if (heart==null){
            likes.setHeart("like");
            likeRepository.save(likes);
        } else {
            likeRepository.delete(likes);
        }
        int count = likeRepository.findAllByPost(post).size();
        post.setLikeCount(count);
        postRepository.save(post);

    }

    public boolean checkLike(유저토큰 토큰, Long postId){
        User user = userRepository.findById(로그인유저.getId()).orElseThrow(
                ()->new NullPointerException("해당 ID가 존재하지 않습니다.")
        );
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );
        if (likeRepository.findByUserAndPost(user, post)==null){
            return true;
        }else {
            return false;
        }
    }
}