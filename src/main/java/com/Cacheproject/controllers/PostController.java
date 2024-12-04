package com.Cacheproject.controllers;

import com.Cacheproject.dtos.PostCommentDto;
import com.Cacheproject.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {
    private OrderService orderService;

    @GetMapping("/post-comments")
    public List<PostCommentDto> getPostComments() {
        return this.orderService.postComments();
    }
}
