package christmas.enums.badge.benefit;

import christmas.enums.badge.Badge;

public enum BenefitBadge implements Badge {
    STAR("별",5_000)
    , TREE("트리",10_000)
    , SANTA("산타",20_000);

    private final String name;
    private final Integer benefitCondition;

    BenefitBadge(String name, Integer benefitCondition) {
        this.name = name;
        this.benefitCondition = benefitCondition;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getCondition() {
        return benefitCondition;
    }
}