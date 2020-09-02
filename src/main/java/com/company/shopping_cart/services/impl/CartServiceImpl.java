package com.company.shopping_cart.services.impl;

import com.company.shopping_cart.entity.Cart;
import com.company.shopping_cart.entity.Order;
import com.company.shopping_cart.entity.Product;
import com.company.shopping_cart.enums.CartStatus;
import com.company.shopping_cart.enums.OrderStatus;
import com.company.shopping_cart.form.CartForm;
import com.company.shopping_cart.form.ProductQuantityForm;
import com.company.shopping_cart.pojo.UserPrincipal;
import com.company.shopping_cart.repository.CartRepository;
import com.company.shopping_cart.repository.OrderRepo;
import com.company.shopping_cart.repository.ProductRepo;
import com.company.shopping_cart.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    @Transactional
    public void addToCart(CartForm cartForm, UserPrincipal user) {
        List<Cart> cartList = new ArrayList<>();
        for (ProductQuantityForm productQuantityForm : cartForm.getProductQuantityForms()) {
            Cart cart = new Cart();
            cart.setCartStatus(CartStatus.NOT_CLEARED.getId());
            cart.setProductId(productQuantityForm.getProductId());
            cart.setQuantity(productQuantityForm.getQuantity());
          //  Product product = productRepo.findById(productQuantityForm.getProductId()).get();
            cart.setUserId(user.getId());
           // cart.setProduct(product);
            cartList.add(cart);
        }
        cartRepository.saveAll(cartList);

    }

    @Override
    public List<Cart> listCart(UserPrincipal user) {
        List<Cart> carts = cartRepository.findAllByuserIdAndCartStatus(user.getId(),CartStatus.NOT_CLEARED.getId());
        return carts;
    }

    @Override
    @Transactional
    public void placeOrder(CartForm cartForm, UserPrincipal user) {
        List<Order> orders = new ArrayList<>();
        for (ProductQuantityForm productQuantityForm : cartForm.getProductQuantityForms()) {
            Order order = new Order();
            Product product = productRepo.findById(productQuantityForm.getProductId()).get();
            order.setProduct(product);
            order.setUserId(user.getId());
            order.setQuantity(productQuantityForm.getQuantity());
            order.setProductId(productQuantityForm.getProductId());
            order.setOrderStatus(OrderStatus.NOT_COMPLETED.getId());
            orders.add(order);
        }
        orderRepo.saveAll(orders);
    }

    @Override
    public List<Order> listOrder() {
        List<Order> orders = new ArrayList<>();
                orderRepo.findAll().forEach(orders::add);
        return orders;
    }
}
