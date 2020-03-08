package com.company.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.company.view.TextConstant.*;

/**
 * Created by student on 26.09.2017.
 */
public class View {

    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("ua", "UA"));  // Ukrainian
    //new Locale("en"));        // English

    //Utilities methods

    /**
     * @param message
     */
    private void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * @param message
     * @return
     */
    private String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    public void printStringInput(String message) {
        printMessage(concatenationString(
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }

    public void printWrongStringInput(String message) {
        printMessage(concatenationString(
                bundle.getString(WRONG_INPUT_DATA),
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }


    public String getRegexName() {
        return bundle.getString(NAME_REGEX);
    }

    public String getRegexLogin() {
        return bundle.getString(LOGIN_REGEX);
    }

    public void printNotUniqueLoginMessage() {
        printMessage(bundle.getString(NOT_UNIQUE_LOGIN));
    }
}
