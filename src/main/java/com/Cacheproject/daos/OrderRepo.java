package com.Cacheproject.daos;

import com.Cacheproject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {

}
