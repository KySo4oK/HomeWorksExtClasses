package company.view;

import java.io.UnsupportedEncodingException;
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
    //new Locale("en"));

    /**
     * Method, which print message
     *
     * @param message - String, which will be printing
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Method, which input message for input data
     *
     * @param nameOfData - type, which user must input data
     */
    public void printInputMessage(String nameOfData) throws UnsupportedEncodingException {
        printMessage(concatenateStrings(
                getStringFromResourceBundle(INPUT_STRING_DATA),
                getStringFromResourceBundle(nameOfData)));
    }

    /**
     * Method, which input message about wrong input
     *
     * @param nameOfData - type, which user must input data
     */
    public void printWrongInputMessage(String nameOfData) throws UnsupportedEncodingException {
        printMessage(concatenateStrings(
                getStringFromResourceBundle(WRONG_INPUT_STRING_DATA),
                getStringFromResourceBundle(INPUT_STRING_DATA),
                getStringFromResourceBundle(nameOfData)));
    }

    /**
     * Method, which get string from ResourceBundle and change charset
     *
     * @param message - name of data, which be load from .properties
     * @return new String, actually String from .properties with changing charset
     * @throws UnsupportedEncodingException cause app has problem with charset's and I make decision to change charset
     */
    public String getStringFromResourceBundle(String message) throws UnsupportedEncodingException {
        return new String(resourceBundle.getString(message).getBytes("ISO-8859-1"), "UTF-8");
    }

    /**
     * Method, which change array of String to one String using StringBuilder
     *
     * @param messages - array of String, which will be append to each other
     * @return result of appending
     */
    public String concatenateStrings(String... messages) {
        StringBuilder result = new StringBuilder();
        for (String message : messages) {
            result.append(message);
        }
        return new String(result);
    }
}
