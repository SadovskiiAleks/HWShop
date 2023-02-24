package org.example;

import org.example.managerOfSystem.ManagerOfSystem;
import org.example.managerOfSystem.product.Electronics;
import org.example.managerOfSystem.product.perents.Manufacturer;
import org.example.managerOfSystem.product.perents.Сattegory;
import org.example.managerOfSystem.product.Сosmetics;
import org.example.shop.Shop;
import org.example.userInterface.UserInterface;

public class Main {
    public static void main(String[] args) {
        // Создадим новый магазин
        Shop shop = new Shop("ОЗОН");

        //Создадим службу доставки
        shop.addDelivery(shop);

        //Создадим склады
        shop.addNewStock("СПб", 100);
        shop.addNewStock("Уфа", 100);
        shop.addNewStock("Москва", 100);

        // Создадим точки выдачи заказов
        shop.addNewPointOfIssueOfOrders("Парфеновская", shop);
        shop.addNewPointOfIssueOfOrders("Ленина", shop);
        shop.addNewPointOfIssueOfOrders("Масковская", shop);

        // Добавим на склад товары, через менеджера управления
        ManagerOfSystem managerOfSystem = new ManagerOfSystem("Александр");
        setProduct(managerOfSystem, shop);

        //Регистрация новго пользователя
        UserInterface userInterface = new UserInterface(shop, "Александр");
        userInterface.setAddressOfPIO();

        //Вывод доступных для покупки товаров
        System.out.println("Вывод доступных для покупки товаров");
        userInterface.showProduct();
        System.out.println("");

        //Фильтрация товаров по ключевым словам
        System.out.println("Фильтрация товаров по ключевым словам");
        userInterface.showProduct("Дрель");
        System.out.println("");

        //Фильтрация товаров по ценам
        System.out.println("Фильтрация товаров по ценам");
        userInterface.showProduct(8000);
        System.out.println("");

        //Фильтрация товаров по производителям
        System.out.println("Фильтрация товаров по производителям");
        userInterface.showProduct(Manufacturer.RUSSIA);
        System.out.println("");

        //Составление продуктовой корзины пользователя
        userInterface.addBasket(userInterface.getProduct("Дрель", Сattegory.ELECTRONICS, Manufacturer.RUSSIA, 2990), 2);
        userInterface.addBasket(userInterface.getProduct("Лобзик", Сattegory.ELECTRONICS, Manufacturer.RUSSIA, 1990), 2);
        userInterface.addBasket(userInterface.getProduct("Туш", Сattegory.COSMETICS, Manufacturer.RUSSIA, 2990), 2);

        //Система рейтинга для товаров
        //Простая рекомендательная система для покупок
        userInterface.order();

        //Трекинг заказа в системе доставки
        shop.delivery.sendCargoToPIO();
        shop.getListOfPIO().get(0).getSupply(1);

        //Возврат заказа, повтороение заказа
        shop.getListOfPIO().get(0).returnOderToStok();
    }

    public static void setProduct(ManagerOfSystem managerOfSystem, Shop shop) {
        Electronics electronics1 = new Electronics("Дрель", Manufacturer.RUSSIA, 2990, Сattegory.ELECTRONICS);
        electronics1.addRating(5);
        Electronics electronics2 = new Electronics("Лобзик", Manufacturer.RUSSIA, 1990, Сattegory.ELECTRONICS);
        electronics2.addRating(3);
        Electronics electronics3 = new Electronics("Шуруповерт", Manufacturer.USA, 8990, Сattegory.ELECTRONICS);
        electronics3.addRating(4);
        Electronics electronics4 = new Electronics("Фен", Manufacturer.BANGKOK, 590, Сattegory.ELECTRONICS);
        electronics4.addRating(5);
        Electronics electronics5 = new Electronics("Пылесос", Manufacturer.THAILAND, 990, Сattegory.ELECTRONICS);
        electronics5.addRating(5);

        managerOfSystem.addPositionAndStock(shop, shop.getStock("СПб"), electronics1, 20);
        managerOfSystem.addPositionAndStock(shop, shop.getStock("СПб"), electronics2, 20);
        managerOfSystem.addPositionAndStock(shop, shop.getStock("СПб"), electronics3, 20);
        managerOfSystem.addPositionAndStock(shop, shop.getStock("СПб"), electronics4, 20);
        managerOfSystem.addPositionAndStock(shop, shop.getStock("СПб"), electronics5, 20);

        managerOfSystem.addPositionAndStock(shop, shop.getStock("Уфа"), electronics1, 20);
        managerOfSystem.addPositionAndStock(shop, shop.getStock("Уфа"), electronics2, 20);
        managerOfSystem.addPositionAndStock(shop, shop.getStock("Уфа"), electronics3, 20);
        managerOfSystem.addPositionAndStock(shop, shop.getStock("Уфа"), electronics4, 20);
        managerOfSystem.addPositionAndStock(shop, shop.getStock("Уфа"), electronics5, 20);

        Сosmetics сosmetics1 = new Сosmetics("Туш", Manufacturer.RUSSIA, 2990, Сattegory.COSMETICS);
        сosmetics1.addRating(5);
        Сosmetics сosmetics2 = new Сosmetics("Помада", Manufacturer.USA, 1990, Сattegory.COSMETICS);
        сosmetics2.addRating(5);
        Сosmetics сosmetics3 = new Сosmetics("Пакетик", Manufacturer.RUSSIA, 990, Сattegory.COSMETICS);
        сosmetics3.addRating(5);
        Сosmetics сosmetics4 = new Сosmetics("Ушные палочки", Manufacturer.THAILAND, 90, Сattegory.COSMETICS);
        сosmetics4.addRating(5);
        Сosmetics сosmetics5 = new Сosmetics("Крем", Manufacturer.BANGKOK, 190, Сattegory.COSMETICS);
        сosmetics5.addRating(5);

        managerOfSystem.addPositionAndStock(shop, shop.getStock("СПб"), сosmetics1, 20);
        managerOfSystem.addPositionAndStock(shop, shop.getStock("СПб"), сosmetics2, 20);
        managerOfSystem.addPositionAndStock(shop, shop.getStock("СПб"), сosmetics3, 20);
        managerOfSystem.addPositionAndStock(shop, shop.getStock("СПб"), сosmetics4, 20);
        managerOfSystem.addPositionAndStock(shop, shop.getStock("СПб"), сosmetics5, 20);


    }
}