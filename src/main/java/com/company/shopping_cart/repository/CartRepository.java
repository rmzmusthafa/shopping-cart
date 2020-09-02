package com.company.shopping_cart.repository;


import com.company.shopping_cart.entity.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart,Long> {

    List<Cart> findAllByuserIdAndCartStatus(Long id, Long id1);
}
