package com.clonecodingproject.clone_coding_project_9_teams.service;

import com.clonecodingproject.clone_coding_project_9_teams.domain.*;
import com.clonecodingproject.clone_coding_project_9_teams.dto.ImageRequestDto;
import com.clonecodingproject.clone_coding_project_9_teams.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public List<ImageUrl> imageSave(List<ImageRequestDto> imageRequestDtos) {
        List<ImageUrl> imageUrls = new ArrayList<>();

        for (ImageRequestDto imageRequestDto : imageRequestDtos) {
            imageUrls.add(new ImageUrl(imageRequestDto));
        }
        return imageRepository.saveAll(imageUrls);
    }

    public void updateToPost(List<ImageUrl> imageUrls, Post post) {
        for (ImageUrl imageUrl : imageUrls) {
            imageUrl.updateToPost(post);
        }
    }
}
