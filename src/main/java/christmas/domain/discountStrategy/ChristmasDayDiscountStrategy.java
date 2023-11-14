package christmas.domain.discountStrategy;

import christmas.domain.DiscountStrategy;
import christmas.domain.Order;

import java.time.LocalDate;

class ChristmasDayDiscountStrategy implements DiscountStrategy {
    private static final int START_DISCOUNT_AMOUNT = 1000;
    private static final LocalDate CHRISTMAS_DAY = LocalDate.of(2023, 12, 25);

    @Override
    public boolean isApplicable(LocalDate visitDate,Order order) {
        return  visitDate.isBefore(CHRISTMAS_DAY.plusDays(1));
    }

    @Override
    public int calculateDiscount(LocalDate visitDate, Order order) {
        int elapsedDays = visitDate.getDayOfMonth() - 1;
        return  - (START_DISCOUNT_AMOUNT + (100 * elapsedDays));
    }

    @Override
    public String getRuleName() {
        return "크리스마스 디데이 할인: ";
    }

}