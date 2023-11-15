package christmas.controller;


import christmas.domain.*;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static christmas.constans.ExceptionMessage.INVALID_DATE;
import static christmas.constans.ExceptionMessage.INVALID_ORDER;

public class ChristmasController {
    private static final String ORDER_DELIMITER = ",";
    private static final String FOOD_QUANTITY_DELIMITER = "-";

    private ChristmasService christmasService = new ChristmasService();
    private LocalDate visitDate;
    private Order order;
    private Optional<GiftMenu> giftMenu;
    private int totalBenefits;
    private int finalPrice;

    public void start() {
        set();
        EventPlanner();
        getPlannerResult();
    }

    private void set(){
        OutputView.printWelcomeMessage();
        visitDate = readVisitDate();
        order = readOrder();
    }

    private void EventPlanner() {
        int totalPrice = order.getTotalPrice();

        Map<String, Integer> allDiscountBenefits = christmasService.getAllDiscountBenefits(visitDate, order);
        giftMenu = GiftMenu.find(totalPrice);

        int totalDiscountPrice = BenefitCalculator.getTotalDiscountPrice(allDiscountBenefits);

        totalBenefits = BenefitCalculator.getTotalBenefits(totalDiscountPrice, giftMenu);
        finalPrice = BenefitCalculator.getFinalPrice(totalPrice, totalDiscountPrice);
    }


    private void getPlannerResult() {
        OutputView.printEventPreview(visitDate);
        OutputView.printOrderedMenu(order);
        OutputView.printTotalPrice(order.getTotalPrice());
        OutputView.printGiftMenu(giftMenu);
        OutputView.printDiscountBenefits(christmasService.getAllDiscountBenefits(visitDate, order));
        OutputView.printTotalBenefits(totalBenefits);
        OutputView.printFinalPrice(totalBenefits);
        OutputView.printEventBadge(EventBadge.find(totalBenefits));
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
            return new Order(orderedFoods);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readOrder();
        }
    }

    private int convertVisitDateInputToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE.get());
        }
    }

    private List<OrderedFood> processOrder(String orderInput){
        List<OrderedFood> orderedFoods = new ArrayList<>();

        String[] orders = orderInput.split(ORDER_DELIMITER);
        for (String order : orders) {
            orderedFoods.add(processOrderedFood(order));
        }

        return orderedFoods;
    }

    private OrderedFood processOrderedFood(String order) {
        String[] parts = order.split(FOOD_QUANTITY_DELIMITER);
        String foodName = parts[0].trim();
        int quantity = convertOrderedQuantityInputToInt(parts[1].trim());
        return new OrderedFood(foodName,quantity);
    }

    private int convertOrderedQuantityInputToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }
    }
}
