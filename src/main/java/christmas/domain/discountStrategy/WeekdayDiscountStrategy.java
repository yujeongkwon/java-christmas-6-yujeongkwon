package christmas.domain.discountStrategy;

import christmas.domain.DiscountStrategy;
import christmas.domain.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayDiscountStrategy implements DiscountStrategy {
    private static final int DISCOUNT_AMOUNT_PER_DESSERT = 2023;
    private static final DayOfWeek START_WEEKDAY = DayOfWeek.SUNDAY;
    private static final DayOfWeek END_WEEKDAY = DayOfWeek.THURSDAY;

    @Override
    public boolean isApplicable(LocalDate visitDate, Order order) {
        return isWeekday(visitDate) && (order.getDessertMenuCount() > 1);
    }

    @Override
    public int calculateDiscount(LocalDate visitDate, Order order) {
        int dessertCount = order.getDessertMenuCount();
        return dessertCount * DISCOUNT_AMOUNT_PER_DESSERT;
    }

    @Override
    public String getRuleName() {
        return "평일 할인: ";
    }

    private boolean isWeekday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.compareTo(START_WEEKDAY) >= 0 && dayOfWeek.compareTo(END_WEEKDAY) <= 0;
    }


}
