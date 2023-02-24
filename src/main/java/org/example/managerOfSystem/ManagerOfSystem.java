package org.example.managerOfSystem;

import org.example.managerOfSystem.product.perents.Product;
import org.example.shop.Shop;
import org.example.stock.Stock;

public class ManagerOfSystem {

    private String nameOfManager;

    public ManagerOfSystem(String nameOfManager) {
        this.nameOfManager = nameOfManager;
    }

    //создать новый тип товара
    public void addPosition(Shop shop, Product product) {
        shop.addProduct(product);
    }

    //добавить товар на склад
    public void addToStock(Stock stock, Product product, int quantity) {
        stock.addProduct(product, quantity);
    }

    // создать позицию и добавить товар
    public void addPositionAndStock(Shop shop, Stock stock, Product product, int quantity) {
        //проверка наличия юнита

        shop.addProduct(product);
        stock.addProduct(product, quantity);
    }
}
