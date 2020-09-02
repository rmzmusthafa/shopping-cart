package com.company.shopping_cart.enums;

public enum  CartStatus {

    NOT_CLEARED(1,"NOT_CLEARED"),CLEARED(2,"CLEARED");

    Long id;

    String name;

    CartStatus(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
