package com.Cacheproject.daos;

import com.Cacheproject.entities.Client;
import com.Cacheproject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Long> {

    List<Order> findByClient(Client client);
}
