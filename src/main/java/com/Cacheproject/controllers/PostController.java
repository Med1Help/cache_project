package com.Cacheproject.controllers;

import com.Cacheproject.dtos.PostCommentDto;
import com.Cacheproject.entities.Comment;
import com.Cacheproject.entities.Post;
import com.Cacheproject.services.OrderService;
import com.Cacheproject.services.PostService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${posts-url}")
    private String baseUrl;

    public PostController(PostService postService) {
        this.postService = postService;
    }



    @GetMapping("/fill")
    public ResponseEntity<Object> fillDatabase(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Post>> postResponseEntity = restTemplate.exchange(baseUrl+"/posts", HttpMethod.GET,null,new ParameterizedTypeReference<List<Post>>() {});
        List<Post> posts = postResponseEntity.getBody();
        if(posts == null || posts.isEmpty()){
            return new ResponseEntity<>("posts failed to retrieved: "+postResponseEntity.getBody(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postService.fillDatabase(posts),HttpStatus.OK);
    }

    @GetMapping("/test")
    public String testRedis() {
        try {
            redisTemplate.opsForValue().set("testKey", "Hello, Redis!", 60, TimeUnit.SECONDS);
            String value = redisTemplate.opsForValue().get("testKey");
            return "Value from Redis: " + value;
        } catch (Exception e) {
            return "Redis connection failed: " + e.getMessage();
        }
    }
}
