package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDate visitDate;
    private List<OrderedFood> orderedFoods = new ArrayList<>();;

    public Order(LocalDate visitDate, List<OrderedFood> orderedFoods) {
        this.visitDate = visitDate;
        this.orderedFoods = orderedFoods;
    }

    public void addOrderedItem(OrderedFood orderedFood) {
        orderedFoods.add(orderedFood);
    }

}
