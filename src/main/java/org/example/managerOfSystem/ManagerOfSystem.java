package org.example.managerOfSystem;

import org.example.managerOfSystem.product.perents.Product;
import org.example.shop.Shop;
import org.example.stock.Stock;

public class ManagerOfSystem {

    private String nameOfManager;

    public ManagerOfSystem(String nameOfManager) {
        this.nameOfManager = nameOfManager;
    }

    public void addPosition(Shop shop, Product product) {
        shop.addProduct(product);
    }

    public void addToStock(Stock stock, Product product, int quantity) {
        stock.addProduct(product, quantity);
    }

    public void addPositionAndStock(Shop shop, Stock stock, Product product, int quantity) {
        //проверка наличия юнита

        shop.addProduct(product);
        stock.addProduct(product, quantity);
    }
}
