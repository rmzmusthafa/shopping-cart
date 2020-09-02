package com.company.shopping_cart.controller;

import com.company.shopping_cart.annotation.CurrentUser;
import com.company.shopping_cart.entity.Product;
import com.company.shopping_cart.form.ApiResponse;
import com.company.shopping_cart.pojo.UserPrincipal;
import com.company.shopping_cart.services.ProductService;
import org.hibernate.validator.constraints.EAN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server/product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private static final String ENTERED = "Entered ProductController : ";

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(Product product, @CurrentUser UserPrincipal user){
        LOGGER.info(ENTERED + "addProduct() Method ");
        return  productService.addProduct(product);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateProduct(Product product, @CurrentUser UserPrincipal user){
        LOGGER.info(ENTERED + "updateProduct() Method ");
        return  productService.updateProduct(product);
    }

    @GetMapping("/list")
    public List<Product> listProduct(){
        LOGGER.info(ENTERED + "listProduct() Method ");
        return  productService.listProduct();
    }

    @GetMapping("/listByCategory")
    public List<Product> listByCategory(@RequestParam("category") String category){
        LOGGER.info(ENTERED + "listProduct() Method ");
        return  productService.listByCategory(category );
    }



}
