package com.Cacheproject.dtos;

import jakarta.annotation.security.DeclareRoles;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class PostCommentDto {
    private String title;
    private List<String> comments;
}
