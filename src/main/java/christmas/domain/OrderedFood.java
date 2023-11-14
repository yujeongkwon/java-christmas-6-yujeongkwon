package christmas.domain;


import java.util.Optional;

import static christmas.constans.ExceptionMessage.INVALID_ORDER;

public class OrderedFood {
    private Food food;
    private int quantity;

    public OrderedFood(String orderedFood, int quantity) {
        this.food = validateIncludeMenu(orderedFood);
        this.quantity = validateQuantity(quantity);
    }

    private int validateQuantity(int quantity) {
        return quantity;
    }

    private Food validateIncludeMenu(String orderedFood) {
        Optional<Food> optionalFood = Menu.findFoodByName(orderedFood);

        if (!optionalFood.isPresent()) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }

        return optionalFood.get();
    }
}
