package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static christmas.constans.ExceptionMessage.INVALID_ORDER;

public class Order {
    private LocalDate visitDate;
    private List<OrderedFood> orderedFoods = new ArrayList<>();;

    public Order(LocalDate visitDate, List<OrderedFood> orderedFoods) {
        validate(orderedFoods);
        this.visitDate = visitDate;
        this.orderedFoods = orderedFoods;
    }

    private void validate(List<OrderedFood> orderedFoods) {
        validateDuplicateMenu(orderedFoods);
    }

    private void validateDuplicateMenu(List<OrderedFood> orderedFoods) {
        Set<String> uniqueFoodNames = orderedFoods.stream()
                .map(of -> (String) of.getName())
                .collect(Collectors.toSet());

        if (uniqueFoodNames.size() != orderedFoods.size()) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }
    }


    public void addOrderedItem(OrderedFood orderedFood) {
        orderedFoods.add(orderedFood);
    }

}
