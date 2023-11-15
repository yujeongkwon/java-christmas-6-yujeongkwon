package christmas.view;

import christmas.domain.GiftMenu;
import christmas.domain.Order;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import static christmas.constans.Constants.EVENT_MONTH;

public class OutputView {
    private static final String ORDER_MENU_HEADER = "<주문 메뉴>";
    private static final String TOTAL_PRICE_HEADER = "<할인 전 총주문 금액>";
    private static final String GIFT_MENU_HEADER = "<증정 메뉴>";
    private static final String DISCOUNT_BENEFITS_HEADER = "<혜택 내역>";
    private static final String TOTAL_BENEFITS_HEADER = "<총혜택 금액>";

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printEventPreview(LocalDate visitDate) {
        System.out.println(String.format("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기! \n",
                            EVENT_MONTH, visitDate.getDayOfMonth()));
    }

    public static void printOrderedMenu(Order order) {
        System.out.println(ORDER_MENU_HEADER);
        order.getOrderedFoods().forEach(food -> System.out.println(food.getName() + " " + food.getQuantity() + "개"));
        System.out.println("");
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.println(TOTAL_PRICE_HEADER);
        System.out.println(String.format("%,d원\n", totalPrice));
    }

    public static void printGiftMenu(Optional<GiftMenu> giftMenu) {
        System.out.println(GIFT_MENU_HEADER);
        giftMenu.ifPresentOrElse(
                menu -> System.out.println(menu.getGiftName() + " " + menu.getPrice() + "개"),
                () -> System.out.println("없음")
        );
    }

    public static void printDiscountBenefits(Map<String, Integer> discountBenefits) {
        System.out.println(DISCOUNT_BENEFITS_HEADER);
        discountBenefits.forEach((strategy, amount) ->
                System.out.println(strategy + ": -" + String.format("%,d원", amount)));
    }

    public static void printTotalBenefits(int totalBenefits) {
        System.out.println(TOTAL_BENEFITS_HEADER);
        System.out.printf("%,d원\n", totalBenefits);
    }
}