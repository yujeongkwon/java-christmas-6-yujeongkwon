package christmas.domain;

import java.util.Map;
import java.util.Optional;

public class BenefitCalculator {
    public static int calculateTotalBenefits(Map<String, Integer> discountedInfo, Optional<GiftMenu> giftMenu) {
        discountedInfo.forEach((strategy, amount) ->
                System.out.println(strategy + ": -" + String.format("%,d원", amount)));
        int discountBenefits = discountedInfo.values().stream().mapToInt(Integer::intValue).sum();
        int giftBenefits = giftMenu.map(GiftMenu::getPrice).orElse(0);
        return discountBenefits + giftBenefits;
    }

}
