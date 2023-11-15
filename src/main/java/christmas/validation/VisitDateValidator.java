package christmas.validation;

import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.DateTimeException;
import java.time.LocalDate;

import static christmas.constans.Constants.EVENT_MONTH;
import static christmas.constans.Constants.EVENT_YEAR;
import static christmas.constans.ExceptionMessage.INVALID_DATE;

public class VisitDateValidator {

    public static LocalDate readVisitDate() {
        try {
            int input = convertVisitDateInputToInt(InputView.readVisitDate());
            return createLocalDate(EVENT_YEAR, EVENT_MONTH, input);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readVisitDate();
        }
    }

    private static LocalDate createLocalDate(int year, int month, int dayOfMonth) {
        try {
            return LocalDate.of(year, month, dayOfMonth);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(INVALID_DATE.get());
        }
    }

    private static int convertVisitDateInputToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE.get());
        }
    }
}
