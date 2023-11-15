package christmas.domain.discountStrategy;

import christmas.domain.DiscountStrategy;
import christmas.domain.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayDiscountStrategy implements DiscountStrategy {
    private static final int DISCOUNT_AMOUNT_PER_DESSERT = 2023;
    //일요일이 1부터
    private static final int START_WEEKDAY = DayOfWeek.SUNDAY.getValue() % 7 + 1;
    private static final int END_WEEKDAY = DayOfWeek.THURSDAY.getValue() % 7 + 1;

    @Override
    public boolean isApplicable(LocalDate visitDate, Order order) {
        return isWeekday(visitDate) && (order.getDessertMenuCount() > 0);
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
        int dayValue = date.getDayOfWeek().getValue() % 7 + 1;

        return dayValue >= START_WEEKDAY && dayValue <= END_WEEKDAY;
    }


}
