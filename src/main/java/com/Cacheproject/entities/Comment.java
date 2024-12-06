package com.Cacheproject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
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

    @Lob
    @Column(name = "body", columnDefinition = "TEXT")
    private String body;
}
