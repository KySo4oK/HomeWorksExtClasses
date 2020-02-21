package extclass.view;

import extclass.model.Sound;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    public static final String BUNDLE_NAME = "messages";
    public static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle(BUNDLE_NAME,
                    //new Locale("ua", "UA"));
                    new Locale("en"));

    public void printMainMenu() {
        printMessage(resourceBundle.getString(TextConstant.PRINT_INDEX_OF_OPERATIONS));
        printMessage(resourceBundle.getString(TextConstant.RECORD));
        printMessage(resourceBundle.getString(TextConstant.SORT));
        printMessage(resourceBundle.getString(TextConstant.FIND));
        printMessage(resourceBundle.getString(TextConstant.ADD));
        printMessage(resourceBundle.getString(TextConstant.FIND_LENGTH));
        printMessage(resourceBundle.getString(TextConstant.EXIT));
    }

    public void printWrongInputMessage() {
        printMessage(resourceBundle.getString(TextConstant.WRONG_INPUT));
    }

    public void printAddSoundMenu(ArrayList<Sound> sounds) {
        printSoundNamesWithIndex(sounds);
        printMessage(resourceBundle.getString(TextConstant.SELECT_ID_OF_SONG));
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
        printMessage(resourceBundle.getString(TextConstant.EXIT));
    }

    public void printLength(int length) {
        printMessage(resourceBundle.getString(TextConstant.LENGTH) + length);
    }

    public String concatenateStrings(String... messages) {
        StringBuilder result = new StringBuilder();
        for (String message : messages) {
            result.append(message);
        }
        return new String(result);
    }
}
