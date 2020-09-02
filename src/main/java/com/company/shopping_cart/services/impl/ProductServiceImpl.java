package com.company.shopping_cart.services.impl;

import com.company.shopping_cart.entity.Product;
import com.company.shopping_cart.form.ApiResponse;
import com.company.shopping_cart.repository.ProductRepo;
import com.company.shopping_cart.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    @Transactional
    public ResponseEntity<ApiResponse> addProduct(Product product) {
        productRepo.save(product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product added!"),
                HttpStatus.OK);    }

    @Override
    @Transactional
    public ResponseEntity<ApiResponse> updateProduct(Product product) {
        Optional<Product> oldProduct= productRepo.findById(product.getId());
        if (oldProduct.isPresent()){
            BeanUtils.copyProperties(product,oldProduct.get());
            productRepo.save(oldProduct.get());
            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product updated!"),
                    HttpStatus.OK);
        }

        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product not found!"),
                HttpStatus.OK);     }

    @Override
    public List<Product> listProduct() {

        List<Product> products = new ArrayList<>();
        productRepo.findAll().forEach(products::add);
        return products;
    }

    @Override
    public List<Product> listByCategory(String category) {
        return productRepo.findAllByCategory(category);
    }

}
