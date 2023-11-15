package christmas.domain;

import java.util.Arrays;
import java.util.Optional;

public enum GiftMenu {
    CHAMPAGNE("샴페인", 25000, 120000);

    private String giftName;
    private int price;
    private int beneficialAmount;

    GiftMenu(String giftName, int price, int beneficialAmount) {
        this.giftName = giftName;
        this.price = price;
        this.beneficialAmount = beneficialAmount;
    }

    public String getGiftName() {
        return giftName;
    }

    public int getPrice() {
        return price;
    }

    public Optional<GiftMenu> find(int totalBenefitAmount) {
        return Arrays.stream(values())
                .filter(giftMenu -> totalBenefitAmount >= giftMenu.beneficialAmount)
                .findFirst();
    }
}