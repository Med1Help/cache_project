package com.Cacheproject;

import com.Cacheproject.daos.ClientRepo;
import com.Cacheproject.daos.ProductRepo;
import com.Cacheproject.entities.Client;
import com.Cacheproject.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class CacheApp {

	public static void main(String[] args) {
		SpringApplication.run(CacheApp.class, args);
	}
//	@Bean
//	public CommandLineRunner initializeDatabase(ClientRepo clientRepo, ProductRepo productRepo) {
//		return args -> {
//			// Number of entities to create
//			int clientCount = 10;
//			int productCount = 20000;
//
//			// Generate and save clients
//			List<Client> clients = new ArrayList<>();
//			for (int i = 1; i <= clientCount; i++) {
//				Client client = new Client();
//				client.setName("Client " + i);
//				client.setPhone("123-456-78" + String.format("%02d", i));
//				client.setAdr("Address " + i + ", City " + (i % 5 + 1));
//				clients.add(client);
//			}
//			clientRepo.saveAll(clients);
//
//			// Generate and save products
//			List<Product> products = new ArrayList<>();
//			for (int i = 1; i <= productCount; i++) {
//				Product product = new Product();
//				product.setName("Product " + i);
//				product.setCode("P" + String.format("%03d", i));
//				product.setQuantity((int) (Math.random() * 100) + 1); // Random quantity between 1 and 100
//				product.setPrice((Math.random() * 500) + 10); // Random price between 10 and 510
//				product.setCategory("Category " + (i % 5 + 1));
//				product.setStore("Store " + (i % 3 + 1));
//				products.add(product);
//			}
//			productRepo.saveAll(products);
//
//			System.out.println(clientCount + " clients and " + productCount + " products have been initialized.");
//		};
//	}
}
