package christmas.service;

import christmas.domain.DiscountStrategy;
import christmas.domain.Order;
import christmas.domain.discountStrategy.ChristmasDayDiscountStrategy;
import christmas.domain.discountStrategy.SpecialDiscountStrategy;
import christmas.domain.discountStrategy.WeekdayDiscountStrategy;
import christmas.domain.discountStrategy.WeekendDiscountStrategy;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChristmasService {

    public Map<String, Integer> getAllDiscountBenefits(LocalDate visitDate, Order order) {
        List<DiscountStrategy> discountStrategies = List.of(
                new WeekdayDiscountStrategy(),
                new WeekendDiscountStrategy(),
                new SpecialDiscountStrategy(),
                new ChristmasDayDiscountStrategy());

        return discountStrategies.stream()
                .filter(discountStrategy -> discountStrategy.isApplicable(visitDate, order))
                .collect(Collectors.toMap(
                        discountStrategy -> discountStrategy.getClass().getSimpleName(),
                        discountStrategy -> discountStrategy.calculateDiscount(visitDate, order)
                ));
    }

}
