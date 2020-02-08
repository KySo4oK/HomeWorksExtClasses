package game;

public class View {

    public static final String INPUT_INT_VALUE_IN_RANGE = "Input in value in this range ";
    public static final String SEPARATOR = " - ";
    public static final String WRONG_INPUT_VALUE = "Wrong input value(out of range)";
    public static final String WIN = "You won";
    public static final String STATISTIC = "Value of your attempts ";
    public static final int MAX = 100;
    public static final int MIN = 0;

    public void printMessage(String message) {
        System.out.println(message);
    }
}
