package christmas.controller;


import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.LocalDate;

import static christmas.constans.ExceptionMessage.INVALID_ORDER;

public class ChristmasController {
    private LocalDate visitDate;
    private Order order;

    public void start() {
        set();
    }

    private void set(){
        visitDate = readVisitDate();
    }

    private LocalDate readVisitDate() {
        try {
            int input = convertInputToInt(InputView.readVisitDate());
            return LocalDate.of(2023,12,input);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readVisitDate();
        }
    }
}
