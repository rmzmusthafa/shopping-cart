package com.company.shopping_cart.entity;

import com.company.shopping_cart.form.UserForm;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "order")
public class Order {

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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pId")
    private Product product ;

    @Column(name = "order_status")
    private Long orderStatus;



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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }
}
