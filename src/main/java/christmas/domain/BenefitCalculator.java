package christmas.domain;

import java.util.Map;
import java.util.Optional;

public class BenefitCalculator {
    public static int getTotalBenefits(int totalDiscountPrice, Optional<GiftMenu> giftMenu) {
        int giftBenefits = giftMenu.map(GiftMenu::getPrice).orElse(0);
        return totalDiscountPrice + giftBenefits;
    }

    public static int getFinalPrice(int totalPrice, int totalDiscounted){
        return totalPrice - totalDiscounted;
    }

    public static int getTotalDiscountPrice(Map<String, Integer> discountedInfo) {
        return discountedInfo.values().stream().mapToInt(Integer::intValue).sum();
    }
}
