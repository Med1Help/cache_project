package com.Cacheproject.services;

import com.Cacheproject.daos.OrderRepo;
import com.Cacheproject.dtos.ClientDto;
import com.Cacheproject.dtos.ProductPurchaseDto;
import com.Cacheproject.entities.Client;
import com.Cacheproject.entities.Order;
import com.Cacheproject.entities.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderService {

    private OrderRepo orderRepo;
    private ProductService productService;
    private ClientService clientService;

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
}
