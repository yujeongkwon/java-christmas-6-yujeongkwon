package christmas.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static christmas.constans.Constants.MAX_QUANTITY;
import static christmas.constans.ExceptionMessage.INVALID_ORDER;

public class Order {
    private static final int AVAILABLE_DISCOUNT_MIN_AMOUNT= 10000;

    private List<OrderedFood> orderedFoods = new ArrayList<>();

    public Order(List<OrderedFood> orderedFoods) {
        validate(orderedFoods);
        this.orderedFoods = orderedFoods;
    }

    public boolean isAvailableDiscount(){
        return getTotalPrice() >= AVAILABLE_DISCOUNT_MIN_AMOUNT;
    }

    public int getTotalPrice(){
        return orderedFoods.stream()
                .mapToInt(OrderedFood::getFoodsPrice)
                .sum();
    }

    public int getMainMenuCount() {
        return orderedFoods.stream()
                .filter(food -> Menu.findCategoryByFoodName((String) food.getName()).equals(Menu.MAIN))
                .mapToInt(OrderedFood::getQuantity)
                .sum();
    }

    public int getDessertMenuCount() {
        return orderedFoods.stream()
                .filter(food -> Menu.findCategoryByFoodName((String) food.getName()).equals(Menu.DESSERT))
                .mapToInt(OrderedFood::getQuantity)
                .sum();
    }

    public List<OrderedFood> getOrderedFoods() {
        return orderedFoods;
    }

    private void validate(List<OrderedFood> orderedFoods) {
        validateDuplicateMenu(orderedFoods);
        validateTotalMenuCount(orderedFoods);
        validateNotOnlyBeverage(orderedFoods);
    }

    private void validateDuplicateMenu(List<OrderedFood> orderedFoods) {
        Set<String> uniqueFoodNames = orderedFoods.stream()
                .map(of -> (String) of.getName())
                .collect(Collectors.toSet());

        if (uniqueFoodNames.size() != orderedFoods.size()) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }
    }

    private void validateTotalMenuCount(List<OrderedFood> orderedFoods) {
        int totalMenuCount = orderedFoods.stream()
                .mapToInt(OrderedFood::getQuantity)
                .sum();

        if (totalMenuCount > MAX_QUANTITY) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }
    }

    private void validateNotOnlyBeverage(List<OrderedFood> orderedFoods) {
        Set<String> foodCategories = orderedFoods.stream()
                .map(OrderedFood::getName)
                .map(name -> Menu.findCategoryByFoodName((String) name).getCategoryName())
                .collect(Collectors.toSet());

        if (foodCategories.size() == 1 && foodCategories.contains(Menu.BEVERAGE.getCategoryName())) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }
    }
}
