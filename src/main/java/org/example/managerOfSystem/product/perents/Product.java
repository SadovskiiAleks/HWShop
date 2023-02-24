package org.example.managerOfSystem.product.perents;

import java.util.LinkedList;


public abstract class Product {

    protected Manufacturer manufacturer;
    protected String name;
    protected Сattegory category;
    private int cost;

    protected int overallRating;

    private LinkedList<Integer> arrayOfRating = new LinkedList<>();

    public Product(String name, Manufacturer manufacturer, int cost, Сattegory category) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.cost = cost;
        this.category = category;
    }

    public String getInfo() {
        return name;
    }

    // добавление рейтинга к товару.
    public void addRating(int grade) {
        if (grade <= 5 && grade >= 0) {
            this.arrayOfRating.add(grade);

            int sum = this.arrayOfRating.stream().mapToInt(i -> i).sum();
            int size = this.arrayOfRating.size();
            overallRating = sum / size;
        } else {
            System.out.println("Оценка от 0 до 5");
        }
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    abstract public Сattegory getCategory();

    public int getOverallRating() {
        return overallRating;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
