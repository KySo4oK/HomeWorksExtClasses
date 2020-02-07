package game;

import java.util.ArrayList;

public class Controller {
    private int numberOfAttempts;
    private ArrayList<String> resultsOfAttempts = new ArrayList<>();
    public String compareNumbers(int firstNumber, int secondNumber) {
        numberOfAttempts++;
        if (firstNumber < secondNumber) {
            return "greater";
        } else if(firstNumber > secondNumber) {
            return "lesser";
        } else return "equal";
    }

    public int getRandomNumberBetween_100_0() {
        return (int)Math.random()*101;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public String getStatistic() {
        String result = "";
        for(int i = 0; i < resultsOfAttempts.size(); i++){
            result += resultsOfAttempts.get(i);
        }
        return result;
    }
}

