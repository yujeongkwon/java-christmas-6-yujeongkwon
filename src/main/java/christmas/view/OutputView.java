package christmas.view;

public class OutputView {

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
}