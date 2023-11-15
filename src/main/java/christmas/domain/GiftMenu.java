package christmas.domain;

import java.util.Arrays;
import java.util.Optional;

public enum GiftMenu {
    CHAMPAGNE("샴페인", 25000, 120000, 1);

    private final String giftName;
    private final int price;
    private final int beneficialAmount;
    private final int giftCount;

    GiftMenu(String giftName, int price, int beneficialAmount, int giftCount) {
        this.giftName = giftName;
        this.price = price;
        this.beneficialAmount = beneficialAmount;
        this.giftCount = giftCount;
    }

    public static Optional<GiftMenu> find(int totalBenefitAmount) {
        return Arrays.stream(values())
                .filter(giftMenu -> totalBenefitAmount >= giftMenu.beneficialAmount)
                .findFirst();
    }

    public String getGiftName() {
        return giftName;
    }

    public int getPrice() {
        return price;
    }

    public int getGiftCount() {
        return giftCount;
    }
}