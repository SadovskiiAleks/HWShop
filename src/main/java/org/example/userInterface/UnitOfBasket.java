package org.example.userInterface;

import org.example.managerOfSystem.product.perents.Product;

public class UnitOfBasket {
    private Product product;
    private int quantity;

    private String city;


    public UnitOfBasket(Product product, int quantity, String city) {
        this.product = product;
        this.quantity = quantity;
        this.city = city;
    }

    public String showProduct() {
        return product.getInfo();
    }

    public String getCity() {
        return city;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
