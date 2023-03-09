### Задача Магазин

## Описание
В этом задании попрактикуемся с правилами чистого кода и принципами SOLID.

Нужно написать программу-магазин, в которой пользователи заказывают товары. Вам предоставляется свобода в продумывании функциональности вашей программы, как и в проектировании её структуры. В процессе реализации вы должны применить принцип избегания магических чисел, DRY и как минимум 4 из 5 принципов SOLID, причём явно комментариями в коде или при отправке решения указать по одному примеру применения каждого принципа в вашем решении со ссылками на конкретные места кода на гитхабе.

## Ссылки на применение каждого этого принципа
1. Магические чисела
   * [Ссылка](https://github.com/SadovskiiAleks/HWShop/blob/2ca4f5c238d22f2326eced3ccc9a9d6c7b9a7809/src/main/java/org/example/userInterface/UserInterface.java#L17)
2. DRY
   * [Ссылка](https://github.com/SadovskiiAleks/HWShop/blob/2ca4f5c238d22f2326eced3ccc9a9d6c7b9a7809/src/main/java/org/example/userInterface/UserInterface.java#L144)
3. SOLID
   * [S - принцип единственной ответственности(Single Responsibility Principle)](https://github.com/SadovskiiAleks/HWShop/blob/2ca4f5c238d22f2326eced3ccc9a9d6c7b9a7809/src/main/java/org/example/shop/delivery/Delivery.java#L14)
   * [O - принцип открытости/закрытости(Open Closed Principle)](https://github.com/SadovskiiAleks/HWShop/blob/2ca4f5c238d22f2326eced3ccc9a9d6c7b9a7809/src/main/java/org/example/managerOfSystem/product/perents/Product.java#L5)
   * [L-принцип замены Барбары Лисков(Liskov Substitution Principle)](https://github.com/SadovskiiAleks/HWShop/blob/2ca4f5c238d22f2326eced3ccc9a9d6c7b9a7809/src/main/java/org/example/shop/Shop.java#L11)
   * [I- принцип сегрегации (разделения) интерфейса(Interface Segregation Principle)]  
   * [D- принцип инверсии зависимостей(Dependency Inversion Principle)](https://github.com/SadovskiiAleks/HWShop/blob/2ca4f5c238d22f2326eced3ccc9a9d6c7b9a7809/src/main/java/org/example/managerOfSystem/product/Electronics.java#L19)
## Описание решения


![Схема работы](https://github.com/SadovskiiAleks/HWShop/blob/master/%D0%9F%D1%83%D1%81%D1%82%D0%BE%D0%B9%20%D0%B4%D0%B8%D0%B0%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%BE%D0%B9.jpeg)


## Описание
Примеры возможностей программы:
* Вывод доступных для покупки товаров
* Фильтрация товаров по ключевым словам, ценам, производителям
* Составление продуктовой корзины пользователя
* Трекинг заказа в системе доставки
* Возврат заказа, повтороение заказа
* Система рейтинга для товаров
* Простая рекомендательная система для покупок

## Реализация
1. Продумайте и зафиксируйте список возможностей вашей программы.
2. Продумайте консольный интерфейс взаимодействия пользователя с вашей программой.
3. Продумайте систему классов, которые вам понадобятся для реализации вашей программы.
4. Напишите вашу программу, явно применив вышеперечисленные принципы хорошего кода.
5. При отправке решения укажите, в чём именно было применение каждого этого принципа (по одному примеру) со ссылками на конкретные места кода на гитхабе.
6. Протестируйте работу программы. Не забывайте про правила форматирования кода (для автоформата можете выделить код в идее и нажать **Ctrl+Alt+L**).
