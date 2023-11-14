package christmas.domain.discountStrategy;

import christmas.domain.Order;
import christmas.domain.OrderedFood;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ChristmasDayDiscountStrategyTest {
    private LocalDate localDate;
    private Order order;

    @BeforeEach
    void setup(){
        localDate = LocalDate.of(2023,12,25);

        List<OrderedFood> orderedFoods = List.of(
                new OrderedFood("아이스크림", 2),
                new OrderedFood("제로콜라", 10),
                new OrderedFood("시저샐러드", 3)
        );

        order = new Order(orderedFoods);
    }

    @DisplayName("크리스마스데이 할인 테스트")
    @Test
    void applyDiscount() {
        //given
        ChristmasDayDiscountStrategy christmasDayDiscountStrategy = new ChristmasDayDiscountStrategy();

        //when
        int result = 0;
        if (christmasDayDiscountStrategy.isApplicable(localDate, order)){
            result = christmasDayDiscountStrategy.calculateDiscount(localDate, order);
        }
        //then
        assertThat(result).isEqualTo(-3400);
    }
}