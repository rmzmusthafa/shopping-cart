package com.company.shopping_cart.controller;

import com.company.shopping_cart.annotation.CurrentUser;
import com.company.shopping_cart.entity.Cart;
import com.company.shopping_cart.entity.Order;
import com.company.shopping_cart.form.CartForm;
import com.company.shopping_cart.pojo.UserPrincipal;
import com.company.shopping_cart.services.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/server")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private static final String ENTERED = "Entered OrderController : ";

    @Autowired
    private CartService cartService;

    @PostMapping("/addToCart")
    public void addToCart(CartForm cartForm , @CurrentUser UserPrincipal user){
        LOGGER.info(ENTERED + "addToCart()");
        cartService.addToCart(cartForm,user);
    }

    @GetMapping("/listCart")
    public List<Cart> listCart(@CurrentUser UserPrincipal user){
        LOGGER.info(ENTERED + "listCart()");
        return cartService.listCart(user);
    }

    @PostMapping("/placeOrder")
    public void placeOrder(CartForm cartForm , @CurrentUser UserPrincipal user){
        LOGGER.info(ENTERED + "placeOrder()");
        cartService.placeOrder(cartForm,user);
    }

    @GetMapping("/listOrder")
    public List<Order> listOrder(){
        LOGGER.info(ENTERED + "listOrder()");
        return cartService.listOrder();
    }





}
