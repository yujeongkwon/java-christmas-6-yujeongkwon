package christmas.domain;

import java.time.LocalDate;
import java.util.List;

public interface DiscountStrategy{
    boolean isApplicable(LocalDate visitDate, Order order);

    int calculateDiscount(LocalDate visitDate, Order order);

    String getRuleName();
}
