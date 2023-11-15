package christmas.validation;

import christmas.domain.Order;
import christmas.domain.OrderedFood;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static christmas.constans.ExceptionMessage.INVALID_ORDER;

public class OrderValidator {
    private static final String ORDER_DELIMITER = ",";
    private static final String FOOD_QUANTITY_DELIMITER = "-";

    public static Order readOrder() {
        try {
            List<OrderedFood> orderedFoods = processOrder(InputView.readOrder());
            return new Order(orderedFoods);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readOrder();
        }
    }

    private static List<OrderedFood> processOrder(String orderInput) {
        return Arrays.stream(orderInput.split(ORDER_DELIMITER))
                .map(OrderValidator::processOrderedFood)
                .toList();
    }

    private static OrderedFood processOrderedFood(String order) {
        String[] parts = order.split(FOOD_QUANTITY_DELIMITER);
        String foodName = parts[0].trim();
        int quantity = convertOrderedQuantityInputToInt(parts[1].trim());
        return new OrderedFood(foodName, quantity);
    }

    private static int convertOrderedQuantityInputToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }
    }
}
