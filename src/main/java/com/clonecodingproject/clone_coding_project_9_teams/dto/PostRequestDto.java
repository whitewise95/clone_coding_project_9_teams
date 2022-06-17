package com.clonecodingproject.clone_coding_project_9_teams.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestDto {

    private String title;
    private String category;
    private String content;
    private int price;
    private List<ImageRequestDto> imageUrl;
}
