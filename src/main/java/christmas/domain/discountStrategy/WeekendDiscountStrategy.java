package christmas.domain.discountStrategy;

import christmas.domain.DiscountStrategy;
import christmas.domain.Order;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class WeekendDiscountStrategy implements DiscountStrategy {
    private static final int WEEKEND_DISCOUNT_AMOUNT = 2023;
    private static final DayOfWeek[] WEEKEND_DAYS = {DayOfWeek.FRIDAY, DayOfWeek.SATURDAY};

    @Override
    public boolean isApplicable(LocalDate visitDate, Order order) {
        return isWeekend(visitDate);
    }

    @Override
    public int calculateDiscount(LocalDate visitDate, Order order) {
        int discountAmountPerItem = WEEKEND_DISCOUNT_AMOUNT * order.getMainMenuCount();
        return discountAmountPerItem;
    }

    @Override
    public String getRuleName() {
        return "주말 할인: ";
    }

    private boolean isWeekend(LocalDate date) {
        return Arrays.stream(WEEKEND_DAYS)
                .anyMatch(weekendDay -> date.getDayOfWeek() == weekendDay);
    }
}
