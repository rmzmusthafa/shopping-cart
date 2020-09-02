package com.company.shopping_cart.repository;

import com.company.shopping_cart.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order,Long> {
}
