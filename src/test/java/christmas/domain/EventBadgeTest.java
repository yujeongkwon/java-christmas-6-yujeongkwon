package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class EventBadgeTest {

    @DisplayName("배지 테스트")
    @ParameterizedTest
    @CsvSource({"20000, SANTA",
            "10000, TREE",
            "5000, STAR"})
    void calculateEventBadge(int totalBenefitAmount, EventBadge expectBadge) {

        assertThat(EventBadge.find(totalBenefitAmount)).isEqualTo(expectBadge);

    }
}