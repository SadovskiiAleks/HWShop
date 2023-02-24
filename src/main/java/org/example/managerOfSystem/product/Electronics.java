package org.example.managerOfSystem.product;

import org.example.managerOfSystem.product.perents.Manufacturer;
import org.example.managerOfSystem.product.perents.Product;
import org.example.managerOfSystem.product.perents.Сattegory;

public class Electronics extends Product {

    public Electronics(String name, Manufacturer manufacturer, int cost, Сattegory category) {
        super(name, manufacturer, cost, category);
    }

    @Override
    public String getInfo() {
        return name + manufacturer + category + overallRating;
    }

    @Override
    public Сattegory getCategory() {
        return category;
    }


}
