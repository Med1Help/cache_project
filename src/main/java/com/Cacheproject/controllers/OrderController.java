package com.Cacheproject.controllers;

import com.Cacheproject.dtos.ClientDto;
import com.Cacheproject.dtos.PostCommentDto;
import com.Cacheproject.dtos.ProductPurchaseDto;
import com.Cacheproject.entities.Order;
import com.Cacheproject.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController  {
    private final OrderService orderService;

    /**
     * Endpoint to handle the purchase of an order.
     *
     * @param productDto ProductPurchaseDto containing product details.
     * @param clientDto  ClientDto containing client details.
     * @return ResponseEntity with the created Order or a Bad Request status.
     */
    @PostMapping("/purchase")
    public ResponseEntity<Order> purchaseOrder(@RequestBody ProductPurchaseDto productDto, @RequestBody ClientDto clientDto) {
        Order order = orderService.purchaseOrder(productDto, clientDto);
        if (order == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(order);
    }

    /**
     * Endpoint to retrieve all orders for a specific client.
     *
     * @param clientDto ClientDto containing client details.
     * @return ResponseEntity with the list of orders for the client.
     */
    @GetMapping("/client-orders")
    public ResponseEntity<List<Order>> getClientOrders(@RequestBody ClientDto clientDto) {
        List<Order> orders = orderService.getClientOrder(clientDto);
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/post-comments")
    public List<PostCommentDto> getPostComments() {
        return orderService.postComments();
    }
}
