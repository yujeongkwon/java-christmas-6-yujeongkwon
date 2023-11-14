package christmas.domain;

import christmas.constans.Category;

public class Food {
    private String name;
    private int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
}