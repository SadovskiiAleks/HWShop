package org.example.shop;

import org.example.pointOfIssueOfOrders.PointOfIssueOfOrders;
import org.example.shop.delivery.Delivery;
import org.example.managerOfSystem.product.perents.Product;
import org.example.stock.Stock;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    final String name;
    protected List<Product> listOfProduct = new ArrayList<>();
    protected List<PointOfIssueOfOrders> listOfPIO = new ArrayList<>();
    protected List<Stock> listOfStock = new ArrayList<>();
    public Delivery delivery;


    public Shop(String name) {
        this.name = name;
    }

    public void addDelivery(Shop shop) {
        delivery = new Delivery(shop);
    }

    public void addNewPointOfIssueOfOrders(String addressOfPIO, Shop shop) {
        listOfPIO.add(new PointOfIssueOfOrders(addressOfPIO, shop));
    }

    public void addNewStock(String city, int amountOfStorageRoms) {
        listOfStock.add(new Stock(city, amountOfStorageRoms));
    }

    public List<Stock> getListOfStock() {
        return listOfStock;
    }

    public List<PointOfIssueOfOrders> getListOfPIO() {
        return listOfPIO;
    }


    public List<Product> getlistOfProduct() {

        return listOfProduct;
    }

    public Stock getStock(String nameOfCity) {
        return listOfStock.stream()
                .filter(x -> (x.getCity() == nameOfCity))
                .findFirst()
                .orElse(null);
    }

    public void addProduct(Product product) {
        listOfProduct.add(product);
    }

    public List<Product> showShop() {
        return listOfProduct;
    }
}
