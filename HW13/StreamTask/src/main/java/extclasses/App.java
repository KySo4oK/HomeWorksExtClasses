package extclasses;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

    }

    public double getAverageWithAverageFunc(int[] ints) {
        return IntStream.of(ints)
                .average()
                .getAsDouble();
    }

    public double getAverageWithoutAverageFunc(int[] ints) {
        IntSummaryStatistics intSummaryStatistics =
                IntStream
                        .of(ints)
                        .summaryStatistics();
        return (double) (intSummaryStatistics.getSum()/intSummaryStatistics.getCount());
    }

    public int[] getMinValueWithIndex(int[] ints) {
       return null;
    }

    public long countEqualsZero(int[] ints) {
        return IntStream
                .of(ints)
                .filter(x -> x == 0)
                .count();
    }

    public long countMoreThanZero(int[] ints) {
        return IntStream
                .of(ints)
                .filter(x -> x > 0)
                .count();
    }

    public int[] multiplyWithNumber(int[] ints, final int number) {
        return IntStream
                .of(ints)
                .map(x -> x = x * number)
                .toArray();
    }
}
