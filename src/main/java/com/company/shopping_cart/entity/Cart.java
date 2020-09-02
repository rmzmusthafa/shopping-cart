package com.company.shopping_cart.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product__id")
    private Long productId;

    @Column(name = "quantity")
    @Min(value = 0, message = "*Quantity has to be non negative number")
    private Long Quantity;

    @Column(name = "cart_status")
    private Long cartStatus;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "pId")
//    private Product product ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return Quantity;
    }

    public void setQuantity(Long quantity) {
        Quantity = quantity;
    }

    public Long getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(Long cartStatus) {
        this.cartStatus = cartStatus;
    }

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
}
