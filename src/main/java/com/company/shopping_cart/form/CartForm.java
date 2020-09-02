package com.company.shopping_cart.form;

import java.util.List;

public class CartForm {

    List<ProductQuantityForm> productQuantityForms ;

    public List<ProductQuantityForm> getProductQuantityForms() {
        return productQuantityForms;
    }

    public void setProductQuantityForms(List<ProductQuantityForm> productQuantityForms) {
        this.productQuantityForms = productQuantityForms;
    }
}
