package christmas.domain;

import java.time.LocalDate;

public interface DiscountStrategy {
    boolean isApplicable(LocalDate visitDate, Order order);

    int calculateDiscount(LocalDate visitDate, Order order);

    String getRuleName();
}
