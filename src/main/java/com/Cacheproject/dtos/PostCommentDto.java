package com.Cacheproject.dtos;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PostCommentDto {
    private String title;
    private List<String> comments;
}
