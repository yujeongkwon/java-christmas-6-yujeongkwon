package christmas.exception;

public enum ExceptionMessage {
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),;

    private static final String START = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String get() {
        return START + this.message;
    }

    public String get(int number) {
        return String.format(START + this.message, number);
    }

}