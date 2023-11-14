package christmas.controller;


import christmas.domain.Order;
import christmas.domain.OrderedFood;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static christmas.constans.ExceptionMessage.INVALID_ORDER;

public class ChristmasController {
    private static final String ORDER_DELIMITER = ",";
    private static final String FOOD_QUANTITY_DELIMITER = "-";


    private LocalDate visitDate;
    private Order order;

    public void start() {
        set();
    }

    private void set(){
        visitDate = readVisitDate();
        order = readOrder();
    }

    private LocalDate readVisitDate() {
        try {
            int input = convertVisitDateInputToInt(InputView.readVisitDate());
            return LocalDate.of(2023,12,input);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readVisitDate();
        }
    }

    private Order readOrder() {
        try {
            List<OrderedFood> orderedFoods = processOrder(InputView.readOrder());
            return new Order(visitDate, orderedFoods);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readOrder();
        }
    }

    private int convertVisitDateInputToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }
    }

    private List<OrderedFood> processOrder(String orderInput){
        List<OrderedFood> orderedFoods = new ArrayList<>();

        String[] orders = orderInput.split(ORDER_DELIMITER);
        for (String order : orders) {
            String[] parts = order.split(FOOD_QUANTITY_DELIMITER);
            String foodName = parts[0].trim();
            int quantity = Integer.parseInt(parts[1].trim());
            orderedFoods.add(new OrderedFood(foodName,quantity));
        }

        return orderedFoods;
    }
}
