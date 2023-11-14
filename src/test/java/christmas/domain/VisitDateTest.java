package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static christmas.constans.ExceptionMessage.INVALID_ORDER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VisitDateTest {

    @DisplayName("방문 날짜 입력 값이 빈 값, 1~31 범위가 아닌 것에 대한 예외 검증")
    @ValueSource(strings = {"", "kyj", "5j", "0", "50", "-13"})
    @ParameterizedTest
    void invalidOrder(String input){
        //given, when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> new VisitDate(input));

        //then
        assertThat(exception.getMessage()).isEqualTo(INVALID_ORDER.get());
    }

}