package com.company.shopping_cart.repository;

import com.company.shopping_cart.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product , Long> {

    List<Product> findAllByCategory(String category);
}
