package org.example.stock;

import org.example.managerOfSystem.product.perents.Product;

public class QuantityInStock {

    private Product product;
    private int quantity;

    public QuantityInStock(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
