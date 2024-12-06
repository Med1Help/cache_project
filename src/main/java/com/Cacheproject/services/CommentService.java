package com.Cacheproject.services;

import com.Cacheproject.daos.CommentRepo;
import com.Cacheproject.entities.Comment;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public List<Comment> fillDatabase(List<Comment> comments) {
        return commentRepo.saveAll(comments);
    }

    @Cacheable(value = "comments-cache", key = "'all-comments'")
    public List<Comment> getComments() {
        System.out.println("Fetching comments from the database...");
        return commentRepo.findAll();
    }
}
