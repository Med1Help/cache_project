package com.Cacheproject.services;

import com.Cacheproject.daos.PostRepo;
import com.Cacheproject.dtos.PostCommentDto;
import com.Cacheproject.entities.Comment;
import com.Cacheproject.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class PostService {

    private final PostRepo postRepo;

    public PostService(PostRepo postRepo, CommentService commentService) {
        this.postRepo = postRepo;
    }
    public List<Post> fillDatabase(List<Post> posts) {
        return postRepo.saveAll(posts);
    }

    @Cacheable(value = "posts-cache", key = "'all-posts'")
    public List<Post> getPosts() {
        System.out.println("Fetching posts from the database...");
        return postRepo.findAll();
    }

}
