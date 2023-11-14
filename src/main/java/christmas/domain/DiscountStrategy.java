package christmas.domain;

import java.time.LocalDate;
import java.util.List;

public interface DiscountStrategy{

    int calculateDiscount(LocalDate visitDate, Order order);
    String getRuleName();
}
