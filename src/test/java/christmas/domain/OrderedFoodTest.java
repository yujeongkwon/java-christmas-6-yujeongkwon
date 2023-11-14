package christmas.domain;

import christmas.constans.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderedFoodTest {

    @DisplayName("메뉴판에 없는 메뉴를 주문하면 예외가 발생한다.")
    @Test
    void notIncludeMenu() {
        //given, when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
            new OrderedFood("마라탕",1);
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.INVALID_ORDER.get());
    }

    @DisplayName("올바르지 않은 메뉴 개수를 입력하면 예외가 발생한다.")
    @ValueSource(ints = {0,21})
    @ParameterizedTest
    void invalidQuantity(int input) {
        //given, when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
            new OrderedFood("제로콜라",input);
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.INVALID_ORDER.get());
    }
}