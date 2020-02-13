package company.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static company.view.ConstantContainer.INPUT_STRING_DATA;
import static company.view.ConstantContainer.WRONG_INPUT_STRING_DATA;

/**
 * Entity, which represent view in mvc, actually contains constants and printing method
 */
public class View {
    public static final String BUNDLE_NAME = "messages";
    public static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle(BUNDLE_NAME,
                    new Locale("ua", "UA"));
    //new Locale("en");

    /**
     * Method, which print message
     *
     * @param message - String, which will be printing
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printInputMessage(String nameOfData) {
        printMessage(concatenateStrings(
                resourceBundle.getString(INPUT_STRING_DATA),
                resourceBundle.getString(nameOfData)));
    }

    public void printWrongInputMessage(String nameOfData) {
        printMessage(concatenateStrings(
                resourceBundle.getString(WRONG_INPUT_STRING_DATA),
                resourceBundle.getString(INPUT_STRING_DATA),
                resourceBundle.getString(nameOfData)));
    }

    public String concatenateStrings(String... messages) {
        StringBuilder result = new StringBuilder();
        for (String message : messages) {
            result.append(message);
        }
        return new String(result);
    }
}
