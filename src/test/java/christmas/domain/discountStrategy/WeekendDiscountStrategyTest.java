package christmas.domain.discountStrategy;

import christmas.domain.Order;
import christmas.domain.OrderedFood;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WeekendDiscountStrategyTest {
    private LocalDate localDate;
    private Order order;

    @BeforeEach
    void setup(){
        localDate = LocalDate.of(2023,12,11);

        List<OrderedFood> orderedFoods = List.of(
                new OrderedFood("티본스테이크", 2),
                new OrderedFood("제로콜라", 10),
                new OrderedFood("시저샐러드", 3)
        );

        order = new Order(orderedFoods);
    }

    @DisplayName("주말 할인 테스트")
    @Test
    void applyDiscount() {
        //given
        WeekendDiscountStrategy weekendDiscountStrategy = new WeekendDiscountStrategy();

        //when
        int result = weekendDiscountStrategy.calculateDiscount(localDate, order);

        //then
        assertThat(result).isEqualTo(-4046);
    }
}