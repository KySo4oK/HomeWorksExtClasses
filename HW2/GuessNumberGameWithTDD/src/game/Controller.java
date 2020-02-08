package game;

import com.sun.media.sound.MidiOutDeviceProvider;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        model.setRange(view.MIN, view.MAX);
        model.setRandomNumber();
        inputIntValueWithScanner(scanner);
        view.printMessage(view.WIN);
        view.printMessage(view.STATISTIC + view.SEPARATOR + model.getValueOfAttempts());
    }

    private void inputIntValueWithScanner(Scanner scanner) {
        printWithRange();
        int attemptValue = scanner.nextInt();
        while (!checkValue(attemptValue)) {
            if (checkOutOfRange(attemptValue)) {
                view.printMessage(view.WRONG_INPUT_VALUE);
            } else {
                model.changeRange(attemptValue);
            }
            printWithRange();
            attemptValue = scanner.nextInt();
        }
    }

    private boolean checkOutOfRange(int attemptValue) {
        if ((attemptValue > model.getMax()) || (attemptValue < model.getMin())) {
            return true;
        }
        return false;
    }

    private void printWithRange() {
        view.printMessage(view.INPUT_INT_VALUE_IN_RANGE + model.getMin() + view.SEPARATOR + model.getMax());
    }

    public boolean checkValue(int orderValue) {
        model.addAttempt();
        return model.getOrderValue() == orderValue;
    }
}