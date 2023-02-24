package org.example.shop.delivery;


import org.example.managerOfSystem.product.perents.Product;
import org.example.pointOfIssueOfOrders.PointOfIssueOfOrders;
import org.example.shop.Shop;
import org.example.stock.QuantityInStock;
import org.example.stock.Stock;
import org.example.userInterface.UnitOfBasket;

import java.util.ArrayList;
import java.util.List;

//S - принцип единственной ответственности(Single Responsibility Principle)
// Служба доставки как отдельный класс со своими методами не включенными в интерфейс пользователя
public class Delivery {

    private List<Supply> listOfSupply = new ArrayList<>();
    private Shop shop;

    public Delivery(Shop shop) {
        this.shop = shop;
    }

    public void addNewSupply(List<UnitOfBasket> listOfBasket, String userName, String addressOfPIO) {
        Supply supply = new Supply(listOfBasket, userName, addressOfPIO);
        System.out.println("Ваш номер для отслеживания: " + supply.showTrackCode());
        listOfSupply.add(supply);
    }

    //отправить посылку
    public void sendCargoToPIO() {
        String addresToPIO = listOfSupply.get(0).getAddressOfPIO();

        PointOfIssueOfOrders pIO = shop.getListOfPIO().stream()
                .filter(x -> (x.getAddressOfPIO().equals(addresToPIO)))
                .findFirst()
                .orElse(null);

        pIO.addSupply(listOfSupply.get(0));
        listOfSupply.remove(0);
    }

    //вернуть посылку
    public void sendCargoToStock(List<UnitOfBasket> listOfReturnOder) {
        for (UnitOfBasket oderReturn : listOfReturnOder) {
            // Найти склад товара
            String cityOfStockOder = oderReturn.getCity();
            Stock stockOfOder = shop.getListOfStock().stream()
                    .filter(x -> (x.getCity().equals(cityOfStockOder)))
                    .findFirst()
                    .orElse(null);

            //Положить товар на склад
            Product product = oderReturn.getProduct();
            int quantity = oderReturn.getQuantity();

            QuantityInStock quantityInStock = stockOfOder.getListProductInStock().stream()
                    .filter(x -> (x.getProduct() == product))
                    .findFirst()
                    .orElse(null);
            quantityInStock.setQuantity(quantity);

        }
    }


}
