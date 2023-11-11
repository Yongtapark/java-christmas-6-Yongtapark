package christmas.manangers;

import static christmas.enums.badge.benefit.BenefitBadge.NONE;
import static christmas.enums.badge.benefit.BenefitBadge.SANTA;
import static christmas.enums.badge.benefit.BenefitBadge.STAR;
import static christmas.enums.badge.benefit.BenefitBadge.TREE;

import christmas.enums.badge.benefit.BenefitBadge;
import christmas.event.EventBenefit;
import christmas.order.Orders;
import java.time.LocalDate;

public class BadgeManager {
    private final WooWaEventManager wooWaEventManager;

    public BadgeManager(WooWaEventManager wooWaEventManager) {
        this.wooWaEventManager = wooWaEventManager;
    }

    public BenefitBadge isBadgeConditionSatisfied(LocalDate reservationDate, Orders orders){
        EventBenefit eventBenefit = wooWaEventManager.activateEvent(reservationDate, orders);
        Integer totalBenefitAmount = eventBenefit.discountBenefit();
        if(isSanta(totalBenefitAmount)){
            return SANTA;
        }
        if(isTree(totalBenefitAmount)){
            return TREE;
        }
        if(isStar(totalBenefitAmount)){
            return STAR;
        }
        return NONE;
    }

    private Boolean isStar(Integer totalBenefitAmount){
        return totalBenefitAmount >= STAR.getAmount();
    }

    private Boolean isTree(Integer totalBenefitAmount){
        return totalBenefitAmount >= TREE.getAmount();
    }

    private Boolean isSanta(Integer totalBenefitAmount){
        return totalBenefitAmount >= SANTA.getAmount();
    }
}