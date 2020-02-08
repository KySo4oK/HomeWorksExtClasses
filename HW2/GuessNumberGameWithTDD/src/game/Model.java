package game;

public class Model {
    private int max;
    private int min;

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
}
