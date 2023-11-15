package christmas.controller;


import christmas.domain.*;
import christmas.validation.OrderValidator;
import christmas.validation.VisitDateValidator;
import christmas.service.ChristmasService;
import christmas.view.OutputView;

import java.time.LocalDate;
import java.util.*;

public class ChristmasController {

    private final ChristmasService christmasService = new ChristmasService();
    private LocalDate visitDate;
    private Order order;
    private Map<String, Integer> allDiscountBenefits;
    private Optional<GiftMenu> giftMenu;
    private int totalBenefits;
    private int finalPrice;

    public void start() {
        set();
        EventPlanner();
        getPlannerResult();
    }

    private void set() {
        OutputView.printWelcomeMessage();
        visitDate = VisitDateValidator.readVisitDate();
        order = OrderValidator.readOrder();
    }

    private void EventPlanner() {
        allDiscountBenefits = christmasService.getAllDiscountBenefits(visitDate, order);

        int totalPrice = order.getTotalPrice();
        int totalDiscountPrice = BenefitCalculator.getTotalDiscountPrice(allDiscountBenefits);

        giftMenu = GiftMenu.find(totalPrice);

        totalBenefits = BenefitCalculator.getTotalBenefits(totalDiscountPrice, giftMenu);
        finalPrice = BenefitCalculator.getFinalPrice(totalPrice, totalDiscountPrice);
    }


    private void getPlannerResult() {
        OutputView.printEventPreview(visitDate);
        OutputView.printOrderedMenu(order);
        OutputView.printTotalPrice(order.getTotalPrice());
        OutputView.printGiftMenu(giftMenu);
        OutputView.printBenefits(allDiscountBenefits,giftMenu);
        OutputView.printTotalBenefits(totalBenefits);
        OutputView.printFinalPrice(finalPrice);
        OutputView.printEventBadge(EventBadge.find(totalBenefits));
    }
}