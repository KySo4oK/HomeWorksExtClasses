package extclass.controller;

import extclass.model.Model;
import extclass.model.Sound;
import extclass.view.TextConstant;
import extclass.view.View;

import java.util.ArrayList;
import java.util.Scanner;

class UtilityController {
    private Model model;
    private View view;
    private Scanner scanner;
    private ArrayList<Sound> result;

    UtilityController(Model model, View view, Scanner scanner) {
        this.model = model;
        this.view = view;
        this.scanner = scanner;
        this.result = new ArrayList<>();
    }

    ArrayList<Sound> inputSoundValue() {
        while (true) {
            view.printMainMenu();
            if (scanner.hasNextInt()) {
                int scanValue = scanner.nextInt();
                switch (scanValue) {
                    case 1:
                    case 6:
                        exit();
                        return result;
                    case 2:
                        sortAndPrint();
                        break;
                    case 3:
                        findByLengthRange();
                        break;
                    case 4:
                        addNewSoundToCollection();
                        break;
                    case 5:
                        model.setCollection(result);
                        view.printLength(model.getLength());
                        break;
                    default: {
                        view.printWrongInputMessage();
                        break;
                    }
                }
            } else {
                view.printWrongInputMessage();
                scanner.nextLine();
            }
        }
    }

    private void sortAndPrint() {
        model.sortByGenre();
        view.printSoundNamesWithIndex(model.getSounds());
    }

    private void exit() {
        view.printSoundNamesWithIndex(result);
        view.printExitMessage();
    }

    private void addNewSoundToCollection() {
        while (true) {
            view.printAddSoundMenu(model.getSounds());
            if (scanner.hasNextInt()) {
                int scanValue = scanner.nextInt();
                if (scanValue > model.getSounds().size()) {
                    view.printWrongInputMessage();
                } else if (scanValue == 0) {
                    return;
                } else {
                    result.add(model.getSounds().get(scanValue - 1));
                }
            } else {
                view.printWrongInputMessage();
                scanner.nextLine();
            }
        }
    }

    private void findByLengthRange() {
        view.printSoundNamesWithIndex(model.getSoundsByRangeOfLength(
                inputMinLength(), inputMaxLength()));
    }

    private int inputMaxLength() {
        return inputLimitOfRange(TextConstant.MAX);
    }

    /**
     * method which return one of limits
     * @param limit - min or max
     * @return one of range limit
     */
    private int inputLimitOfRange(String limit) {
        while (true) {
            view.printMessageFromProperties(limit);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                scanner.nextLine();
                view.printWrongInputMessage();
            }
        }
    }

    private int inputMinLength() {
        return inputLimitOfRange(TextConstant.MIN);
    }
}
