package extclass.view;

import extclass.model.Sound;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;


public class View {
    public static final String BUNDLE_NAME = "messages";
    public static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle(BUNDLE_NAME,
                    // new Locale("ua", "UA"));
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
        printMessageFromProperties(TextConstant.SELECT_ID_OF_SONG);
    }

    public void printSoundNamesWithIndex(ArrayList<Sound> sounds) {
        for (int i = 0; i < sounds.size(); i++) {
            printMessage((i + 1) + ". " + sounds.get(i).toString());
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

    public void printMessageFromProperties(String message) {
        printMessage(resourceBundle.getString(message));
    }
}
