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
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderService {

    private OrderRepo orderRepo;
    private ProductService productService;
    private ClientService clientService;
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

        RestTemplate restTemplate = new RestTemplate();

        //performe http Ge request to get all posts
        ResponseEntity<List<Post>> postResponseEntity = restTemplate.exchange(baseUrl+"/posts", HttpMethod.GET,null,new ParameterizedTypeReference<List<Post>>() {});
        List<Post> posts = postResponseEntity.getBody();

        List<PostCommentDto>  postCommentsList = new ArrayList<>();

        //fetch comments per posts
        if(posts != null) {
            for (Post post : posts) {
                List<String> commentsContent = new ArrayList<>();
                if (post.getId() == 10) {
                    break;
                }
                ResponseEntity<List<Comment>> commentResponseEntity = restTemplate.exchange(baseUrl + "/posts/" + post.getId() + "/comments", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });
                List<Comment> comments = commentResponseEntity.getBody();
                comments.parallelStream().forEach(comment -> {
                    commentsContent.add(comment.getBody());
                });
                postCommentsList.add(new PostCommentDto(post.getTitle(), commentsContent));
            }
        }
        else return new ArrayList<>();

        return postCommentsList;
    }
}
