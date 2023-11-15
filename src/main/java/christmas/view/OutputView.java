package christmas.view;

import java.time.LocalDate;

import static christmas.constans.Constants.EVENT_MONTH;

public class OutputView {

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
}