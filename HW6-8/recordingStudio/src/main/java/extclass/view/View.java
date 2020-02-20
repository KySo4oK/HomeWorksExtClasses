package extclass.view;

import extclass.model.Sound;

import java.util.ArrayList;

public class View {
    public void printMainMenu() {
        printMessage(TextConstant.PRINT_INDEX_OF_OPERATIONS);
        printMessage(TextConstant.RECORD);
        printMessage(TextConstant.SORT);
        printMessage(TextConstant.FIND);
        printMessage(TextConstant.ADD);
        printMessage(TextConstant.FIND_LENGTH);
        printMessage(TextConstant.EXIT);
    }

    public void printWrongInputMessage() {
        printMessage(TextConstant.WRONG_INPUT);
    }

    public void printAddSoundMenu(ArrayList<Sound> sounds) {
        printSoundNamesWithIndex(sounds);
        printMessage(TextConstant.SELECT_ID_OF_SONG);
    }

    public void printSoundNamesWithIndex(ArrayList<Sound> sounds) {
        for (int i = 0; i < sounds.size(); i++) {
            printMessage(sounds.get(i).toString());
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printExitMessage() {
        printMessage(TextConstant.EXIT);
    }

    public void printLength(int length) {
        printMessage(TextConstant.LENGTH + length);
    }

    public String concatenateStrings(String... messages) {
        StringBuilder result = new StringBuilder();
        for (String message : messages) {
            result.append(message);
        }
        return new String(result);
    }
}
