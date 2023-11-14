package christmas.domain;

import christmas.constans.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @DisplayName("중복된 메뉴를 주문하면 예외가 발생한다.")
    @Test
    void notIncludeMenu() {
        //given
        List<OrderedFood> orderedFoods = List.of(
                new OrderedFood("제로콜라", 3),
                new OrderedFood("제로콜라", 3)
        );

        LocalDate visitDate = LocalDate.of(2023, 12, 2);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
            new Order(visitDate, orderedFoods);
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.INVALID_ORDER.get());
    }

    @DisplayName("총 메뉴 개수가 20개가 넘는다면 예외가 발생한다.")
    @Test
    void validateTotalMenuCount() {
        //given
        List<OrderedFood> orderedFoods = List.of(
                new OrderedFood("제로콜라", 19),
                new OrderedFood("시저샐러드", 3)
        );

        LocalDate visitDate = LocalDate.of(2023, 12, 2);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
            new Order(visitDate, orderedFoods);
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.INVALID_ORDER.get());
    }

    @DisplayName("메뉴가 모두 음료라면 예외가 발생한다.")
    @Test
    void validateNotOnlyBeverage() {
        //given
        List<OrderedFood> orderedFoods = List.of(
                new OrderedFood("제로콜라", 10),
                new OrderedFood("레드와인", 3)
        );

        LocalDate visitDate = LocalDate.of(2023, 12, 2);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
            new Order(visitDate, orderedFoods);
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.INVALID_ORDER.get());
    }
}