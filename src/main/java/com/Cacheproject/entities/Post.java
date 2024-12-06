package com.Cacheproject.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post extends BaseEntity implements Serializable {
    private Long id;
    private Long userId;
    private String title;
    private String body;
}
