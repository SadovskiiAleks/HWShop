package org.example.userInterface;

import org.example.managerOfSystem.product.perents.Manufacturer;
import org.example.managerOfSystem.product.perents.Product;
import org.example.managerOfSystem.product.perents.Сattegory;
import org.example.pointOfIssueOfOrders.PointOfIssueOfOrders;
import org.example.shop.Shop;
import org.example.stock.QuantityInStock;
import org.example.stock.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    final Shop shop;
    private static int numberOfRecommendations = 4;//Магическое число
    private String userName;

    private String addressOfPIO;
    protected List<UnitOfBasket> listOfBasket = new ArrayList<>();

    public String city = null;

    public UserInterface(Shop shop, String userName) {
        this.shop = shop;
        this.userName = userName;
    }

    // Выбрать пункт выдачи заказов из магазина
    public void setAddressOfPIO() {
        //Показать ПВЗ
        shop.getListOfPIO().stream()
                .forEach(x -> System.out.println(x.getAddressOfPIO()));

        //Считать нужный
        Scanner scanner = new Scanner(System.in);
        String scannerAddress = scanner.nextLine();

        PointOfIssueOfOrders findPoint = shop.getListOfPIO().stream()
                .filter(x -> (x.getAddressOfPIO().equals(scannerAddress)))
                .findFirst()
                .orElse(null);

        if (findPoint != null && findPoint.getAddressOfPIO().equals(scannerAddress)) {
            addressOfPIO = scannerAddress;
            System.out.println(scannerAddress);
            System.out.println(findPoint.getAddressOfPIO());
        } else {
            System.out.println("Укажите правельный адрес склада");
            setAddressOfPIO();
        }

    }

    //показать все товары
    public void showProduct() {
        shop.getlistOfProduct().stream()
                .forEach(x -> System.out.println(x.getInfo()));

    }

    //показать только товары ключевым словам
    public void showProduct(String keyword) {
        shop.getlistOfProduct().stream()
                .filter(x -> (x.getInfo().contains(keyword) == true))
                .forEach(x -> System.out.println(x.getInfo()));
    }

    //показать только товары по ценам
    public void showProduct(int cost) {
        shop.getlistOfProduct().stream()
                .filter(x -> (x.getCost() >= cost))
                .forEach(x -> System.out.println(x.getInfo()));
    }

    //показать только товары по производителю
    public void showProduct(Manufacturer manufacturer) {
        shop.getlistOfProduct().stream()
                .filter(x -> (x.getManufacturer() == manufacturer))
                .forEach(x -> System.out.println(x.getInfo()));
    }

    public Product getProduct(String name, Сattegory cattegory, Manufacturer manufacturer, int cost) {
        return shop.getlistOfProduct().stream()
                .filter(x -> x.getName() == name)
                .filter(x -> x.getCategory() == cattegory)
                .filter(x -> x.getManufacturer() == manufacturer)
                .filter(x -> x.getCost() == cost)
                .findFirst()
                .orElse(null);
    }


    //Добавить товар в корзину
    public void addBasket(Product product, int quantity) {
        //Проверить склады на количество данного товара
        if (findInStock(product, quantity, Command.FIND) == true) {

            //Отнять нужное количество из складов
            findInStock(product, quantity, Command.DELETE);
            listOfBasket.add(new UnitOfBasket(product, quantity, city));
        }
    }

    //Внести оплату
    public void order() {
        Product[] arrayOfProduct = new Product[numberOfRecommendations];
        //Проверить заполнен ли адрес
        if (addressOfPIO != null) {
            //создать новый заказ на доставку
            shop.delivery.addNewSupply(listOfBasket, userName, addressOfPIO);

            //Показать рекомендуемые товары
            int i = 0;
            while (i == numberOfRecommendations) {
                // Получить первый тип продукта из корзины
                for (UnitOfBasket unit : listOfBasket) {
                    // Пройтись по списку продуктов в магазине и найти его рейтинг
                    List<Product> newListProduct = shop.getlistOfProduct().stream()
                            .filter(x -> (x.getCategory() == unit.getProduct().getCategory()))
                            .filter(x -> (x.getOverallRating() > 4))
                            .toList();
                    int x = 2;
                    // добавить 2 товара с рейтингом максимальным рейтингом
                    for (Product product : newListProduct) {
                        if (x == 0) {
                            break;
                        }
                        product.getInfo();
                        x--;
                        i++;
                    }

                    // пройтись по следующему товару
                }
            }
            listOfBasket = null;
        } else {
            System.out.println("Введите адрес доставки");
        }
    }

    private boolean findInStock(Product product, int quantity, Command command) {
        for (Stock stock : shop.getListOfStock()) {
            for (QuantityInStock quantityInStock : stock.getListProductInStock()) {
                if ((quantityInStock.getProduct() == product) && (quantityInStock.getQuantity() >= quantity)) {
                    this.city = stock.getCity();
                    switch (command) {
                        case DELETE:
                            quantityInStock.setQuantity(-quantity);
                            return true;
                        case FIND:
                            return true;
                    }
                }
            }
        }
        return false;
    }

}
