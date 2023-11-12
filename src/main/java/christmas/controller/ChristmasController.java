package christmas.controller;


import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private VisitDate visitDate;

    public void start() {
        set();
    }

    private void set(){
        visitDate = readVisitDate();
    }

    private VisitDate readVisitDate() {
        try {
            return new VisitDate(InputView.readVisitDate());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readVisitDate();
        }
    }
}
