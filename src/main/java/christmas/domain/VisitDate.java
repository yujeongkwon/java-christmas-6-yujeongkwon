package christmas.domain;

import static christmas.exception.ExceptionMessage.INVALID_ORDER;

public class VisitDate {
    private final int date;

    public VisitDate(String input) {
        int inputDate = convertStringToInt(input);
        validate(inputDate);
        this.date = inputDate;
    }

    public static int convertStringToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }
    }

    private void validate(int input) {
    }


}
