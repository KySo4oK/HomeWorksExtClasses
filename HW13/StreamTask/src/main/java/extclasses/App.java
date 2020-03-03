package extclasses;

import com.sun.istack.internal.NotNull;

import java.awt.List;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return (double) (intSummaryStatistics.getSum() / intSummaryStatistics.getCount());
    }

    public Map.Entry<Integer,Integer> getMinValueWithIndex(int[] ints) {
        return Collections.min(
                IntStream
                        .of(ints)
                        .boxed()
                        .collect(Collectors.toList())
                        .stream()
                        .collect(Collectors.toMap(e -> Arrays.asList(ints).indexOf(e),e -> (Integer) e))
                        .entrySet(), Comparator.comparing(Map.Entry::getValue));
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
