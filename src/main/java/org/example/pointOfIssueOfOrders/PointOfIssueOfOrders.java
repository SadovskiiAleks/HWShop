package org.example.pointOfIssueOfOrders;

import org.example.shop.Shop;
import org.example.shop.delivery.Supply;
import org.example.userInterface.UnitOfBasket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PointOfIssueOfOrders {

    private List<Supply> listOfSupply = new ArrayList<>();
    private List<UnitOfBasket> listOfReturnOder = new ArrayList<>();
    private String addressOfPIO;
    private Shop shop;

    public PointOfIssueOfOrders(String addressOfPIO, Shop shop) {
        this.addressOfPIO = addressOfPIO;
        this.shop = shop;
    }

    //Принять доставленный заказ
    public void addSupply(Supply supply) {
        listOfSupply.add(supply);
    }


    //Отдать заказ
    public void getSupply(int trackCode) {
        Scanner scanner = new Scanner(System.in);

        List<Supply> newListOfSupply;
        newListOfSupply = listOfSupply.stream()
                .filter(x -> (x.showTrackCode() == trackCode))
                .toList();

        for (Supply showSupply : newListOfSupply) {

            for (UnitOfBasket product : showSupply.showTheSupply()) {
                System.out.println("Заберают ли заказ: " + product.showProduct() + " y/n ?");
                String scanChar = scanner.nextLine();

                if (scanChar.charAt(0) == 'y') {

                    // Удалить товары
                }
                if (scanChar.charAt(0) == 'n') {

                    // Добавить товары в кучу возврата
                    listOfReturnOder.add(product);

                }
            }
            listOfSupply.remove(showSupply);
        }
    }

    //Возрат заказа
    public void returnOderToStok() {
        shop.delivery.sendCargoToStock(listOfReturnOder);
    }

    public String getAddressOfPIO() {

        return addressOfPIO;
    }


}
