package christmas.domain;


import java.util.Optional;

import static christmas.constans.Constants.MAX_QUANTITY;
import static christmas.constans.Constants.MIN_QUANTITY;
import static christmas.constans.ExceptionMessage.INVALID_ORDER;

public class OrderedFood {

    private final Food food;
    private final int quantity;

    public OrderedFood(String orderedFood, int quantity) {
        this.food = validateIncludeMenu(orderedFood);
        this.quantity = validateQuantity(quantity);
    }

    private int validateQuantity(int quantity) {
        if (quantity < MIN_QUANTITY || quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }

        return quantity;
    }

    private Food validateIncludeMenu(String orderedFood) {
        Optional<Food> optionalFood = Menu.findFoodByName(orderedFood);

        if (optionalFood.isEmpty()) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }

        return optionalFood.get();
    }

    public int getFoodsPrice() {
        return food.getPrice() * quantity;
    }

    public Object getName() {
        return food.getName();
    }

    public int getQuantity() {
        return quantity;
    }
}
