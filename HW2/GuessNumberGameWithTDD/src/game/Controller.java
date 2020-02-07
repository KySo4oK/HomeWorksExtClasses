package game;

public class Controller {
    public String compareNumbers(int firstNumber, int secondNumber) {
        if (firstNumber < secondNumber) {
            return "greater";
        } else if(firstNumber > secondNumber) {
            return "lesser";
        } else return "equal";
    }
}
