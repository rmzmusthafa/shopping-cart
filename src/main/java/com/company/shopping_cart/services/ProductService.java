package com.company.shopping_cart.services;

import com.company.shopping_cart.entity.Product;
import com.company.shopping_cart.form.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
  
    ResponseEntity<ApiResponse> addProduct(Product product);

    ResponseEntity<ApiResponse> updateProduct(Product product);

    List<Product> listProduct();

    List<Product> listByCategory(String category);
}
