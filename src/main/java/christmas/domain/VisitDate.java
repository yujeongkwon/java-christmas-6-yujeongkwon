package christmas.domain;

import static christmas.constans.ExceptionMessage.INVALID_ORDER;

public class VisitDate {
    private static final int START_MONTH = 1;
    private static final int END_MONTH = 31;

    private final int date;

    public VisitDate(String input) {
        int inputDate = convertStringToInt(input);
        validateNumberRange(inputDate);
        this.date = inputDate;
    }

    private int convertStringToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }
    }

    private void validateNumberRange(int input) {
        if (input < START_MONTH || input > END_MONTH) {
            throw new IllegalArgumentException(INVALID_ORDER.get());
        }
    }


}
