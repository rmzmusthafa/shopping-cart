package com.company.shopping_cart.services;


import com.company.shopping_cart.entity.Cart;
import com.company.shopping_cart.entity.Order;
import com.company.shopping_cart.form.CartForm;
import com.company.shopping_cart.pojo.UserPrincipal;

import java.util.List;

public interface CartService {

    void addToCart(CartForm cartForm, UserPrincipal user);

    List<Cart> listCart(UserPrincipal user);

    void placeOrder(CartForm cartForm, UserPrincipal user);

    List<Order> listOrder();
}
