package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static christmas.constans.Constants.MAX_QUANTITY;
import static christmas.constans.ExceptionMessage.INVALID_ORDER;

public class Order {
    private LocalDate visitDate;
    private List<OrderedFood> orderedFoods = new ArrayList<>();

    public Order(LocalDate visitDate, List<OrderedFood> orderedFoods) {
        validate(orderedFoods);
        this.visitDate = visitDate;
        this.orderedFoods = orderedFoods;
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
