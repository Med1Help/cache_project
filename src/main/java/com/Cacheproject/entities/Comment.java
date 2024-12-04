package com.Cacheproject.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "comments")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comment extends BaseEntity {
    private Long postId;
    private String name;
    private String email;
    private String body;
}
