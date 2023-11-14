package christmas.domain.discountStrategy;

import christmas.domain.DiscountStrategy;
import christmas.domain.Order;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class SpecialDiscountStrategy implements DiscountStrategy {
    private static final int SPECIAL_DISCOUNT_AMOUNT = -1000;
    private static final int CHRISTMAS_DAY = 25;

    @Override
    public boolean isApplicable(LocalDate visitDate, Order order) {
        return isSunday(visitDate) || isChristmas(visitDate);
    }

    @Override
    public int calculateDiscount(LocalDate visitDate, Order order) {
        return SPECIAL_DISCOUNT_AMOUNT;
    }

    @Override
    public String getRuleName() {
        return "특별 할인: ";
    }

    private boolean isSunday(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private boolean isChristmas(LocalDate date) {
        return date.getDayOfMonth() == CHRISTMAS_DAY;
    }
}
