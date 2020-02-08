package game;

import sun.awt.SunHints;

public class Model {
    private int max;
    private int min;
    private int orderValue;
    private int valueOfAttempts;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMin() {
        return min;
    }

    public void setRange(int min, int max) {
        setMin(min);
        setMax(max);
    }

    public void setRandomNumber() {
        int random = (int) (Math.random() * (max - min - 2) + 1);
        setOrderValue(random);
    }

    private void setOrderValue(int orderValue) {
        this.orderValue = orderValue;
    }

    public int getOrderValue() {
        return orderValue;
    }

    public void changeRange(int attemptValue) {
        if (attemptValue > orderValue) {
            max = attemptValue;
        } else {
            min = attemptValue;
        }
    }

    public int getValueOfAttempts() {
        return valueOfAttempts;
    }

    public void addAttempt() {
        valueOfAttempts++;
    }
}
