package com.clonecodingproject.clone_coding_project_9_teams.dto;

import com.clonecodingproject.clone_coding_project_9_teams.domain.ImageUrl;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestDto {

    private Long userId;
    private String title;
    private String category;
    private String content;
    private String price;
    private List<ImageUrl> imageUrl;
}
