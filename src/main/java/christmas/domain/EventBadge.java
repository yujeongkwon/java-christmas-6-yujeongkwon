package christmas.domain;

import java.util.Arrays;
import java.util.Optional;

public enum EventBadge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000);

    private String badgeName;
    private int beneficialAmount;

    EventBadge(String badgeName, int benefitAmount) {
        this.badgeName = badgeName;
        this.beneficialAmount = benefitAmount;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public static Optional<EventBadge> find(int totalBenefitAmount) {
        return Arrays.stream(values())
                .filter(badge -> totalBenefitAmount >= badge.beneficialAmount)
                .findFirst();
    }
}
