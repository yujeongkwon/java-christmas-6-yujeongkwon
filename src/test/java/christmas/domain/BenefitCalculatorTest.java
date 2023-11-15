package christmas.domain;

import christmas.service.ChristmasService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class BenefitCalculatorTest {
    private ChristmasService christmasService = new ChristmasService();
    private LocalDate localDate;
    private Order order;

    @BeforeEach
    void setup(){
        localDate = LocalDate.of(2023,12,25);

        List<OrderedFood> orderedFoods = List.of(
                new OrderedFood("아이스크림", 2),
                new OrderedFood("제로콜라", 5),
                new OrderedFood("시저샐러드", 3),
                new OrderedFood("바비큐립", 3)
        );

        order = new Order(orderedFoods);
    }

    @DisplayName("혜택 총합계 테스트")
    @Test
    void calculateTotalBenefits(){
        //given
        Map<String, Integer> discountedInfo = christmasService.getAllDiscountBenefits(localDate,order);
        Optional<GiftMenu> giftMenu = GiftMenu.find(order.getTotalPrice());
        int totalDiscountPrice = BenefitCalculator.getTotalDiscountPrice(discountedInfo);
        //when
        int result = BenefitCalculator.getTotalBenefits(totalDiscountPrice,giftMenu);

        //then
        assertThat(result).isEqualTo(33446);
    }
}