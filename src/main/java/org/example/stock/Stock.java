package org.example.stock;

import org.example.managerOfSystem.product.perents.Product;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String city;
    private int amountOfStorageRoms;

    private List<QuantityInStock> quantityInStock = new ArrayList<>();

    public Stock(String city, int amountOfStorageRoms) {
        this.city = city;
        this.amountOfStorageRoms = amountOfStorageRoms;
    }

    public void addProduct(Product product, int quantity) {
        //проверка наличия юнита
        //
        this.quantityInStock.add(new QuantityInStock(product, quantity));
    }

    public String getCity() {
        return city;
    }

    public List<QuantityInStock> getListProductInStock() {
        return quantityInStock;
    }
}
