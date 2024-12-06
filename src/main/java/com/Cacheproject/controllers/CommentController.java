package com.Cacheproject.controllers;

import com.Cacheproject.entities.Comment;
import com.Cacheproject.services.CommentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;
    @Value("${posts-url}")
    private String baseUrl;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping("/fill")
    public ResponseEntity<Object> fillDatabase(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Comment>> commentResponseEntity = restTemplate.exchange(baseUrl+"/comments", HttpMethod.GET,null,new ParameterizedTypeReference<List<Comment>>() {});
        List<Comment> comments = commentResponseEntity.getBody();
        if(comments == null || comments.isEmpty()){
            return new ResponseEntity<>("comments failed to retrieved: "+commentResponseEntity.getBody(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(commentService.fillDatabase(comments),HttpStatus.OK);
    }
}
