package com.Cacheproject.services;

import com.Cacheproject.daos.OrderRepo;
import com.Cacheproject.dtos.ClientDto;
import com.Cacheproject.dtos.PostCommentDto;
import com.Cacheproject.dtos.ProductPurchaseDto;
import com.Cacheproject.entities.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepo orderRepo;
    private final ProductService productService;
    private final ClientService clientService;
    private final PostService postService;
    private final CommentService commentService;

    public OrderService(OrderRepo orderRepo, ProductService productService, ClientService clientService, CommentService commentService, PostService postService, PostService postService1, CommentService commentService1, PostService postService2, CommentService commentService2) {
        this.orderRepo = orderRepo;
        this.productService = productService;
        this.clientService = clientService;
        this.postService = postService2;
        this.commentService = commentService2;
    }

    @Value("${posts-url}")
    private String baseUrl;

    /**
     * Processes the purchase of a product by a client and creates a new order.
     */
    public Order purchaseOrder(ProductPurchaseDto productDto, ClientDto clientDto) {
        Product product = this.productService.getProductById(productDto.getProductId()).orElse(null);
        Client client = this.clientService.getClientById(clientDto.getClientId()).orElse(null);
        if( product == null || client == null) {
            return null;
        }
        Order order = Order.builder()
                .qte(productDto.getQuantity())
                .store(productDto.getStore())
                .client(client)
                .product(product)
                .build();
        order = this.orderRepo.save(order);
        return order;
    }

    public List<Order> getClientOrder(ClientDto clientDto) {
        Client client = this.clientService.getClientById(clientDto.getClientId()).orElse(null);
        if(client == null) {
            return new ArrayList<>();
        }
        return this.orderRepo.findByClient(client);
    }
    public List<PostCommentDto> postComments(){

        //get All post from dataase for the first try then from the cache
        List<Post> posts = postService.getPosts();

        //get All comment
        List<Comment> comments = commentService.getComments();
        // Mapped with their postIds from database then from the cache
        Map<Long,List<Comment>> commentsMapped = comments.stream()
                .collect(Collectors.groupingBy(Comment::getPostId));

        List<PostCommentDto>  postCommentsList = new ArrayList<>();

        //fetch comments per posts
        if(posts != null)
            posts.parallelStream().forEach(post -> {
                List<String> commentsContent = commentsMapped.getOrDefault(post.getId(), Collections.emptyList())
                        .stream()
                        .map(Comment::getBody)
                        .toList();
                postCommentsList.add(new PostCommentDto(post.getTitle(), commentsContent));
            });
        else return new ArrayList<>();

        return postCommentsList;
    }
}
