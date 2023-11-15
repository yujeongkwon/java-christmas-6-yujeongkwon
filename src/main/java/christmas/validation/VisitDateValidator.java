package christmas.validation;

import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.LocalDate;

import static christmas.constans.ExceptionMessage.INVALID_DATE;

public class VisitDateValidator {
    public static LocalDate readVisitDate() {
        try {
            int input = convertVisitDateInputToInt(InputView.readVisitDate());
            return LocalDate.of(2023, 12, input);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readVisitDate();
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
