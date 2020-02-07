package test;

import game.Controller;
import org.junit.*;
import org.junit.jupiter.api.BeforeAll;

public class TestGame {
    private static Controller controller;
    private static int attempts;

    @BeforeClass
    public static void initController() {
        controller = new Controller();
    }

    @Test
    public void testComparing_1_and_2() {
        Assert.assertEquals("greater", compareNumbersForTest(1,2));
    }

    @Test
    public void testComparing_2_and_1() {
        Assert.assertEquals("lesser", compareNumbersForTest(2,1));
    }

    @Test
    public void testComparing_1_and_1() {
        Assert.assertEquals("equal", compareNumbersForTest(1,1));
    }

    @Test
    public void testComparing_0_and_1() {
        Assert.assertEquals("greater", compareNumbersForTest(0,1));
    }

    @Test
    public void testRandomRangeLess(){
        Assert.assertEquals("lesser", compareNumbersForTest(101,getRandomNumberFromController()));
    }

    @Test
    public void testRandomRangeMore(){
        Assert.assertEquals("greater", compareNumbersForTest(-1,getRandomNumberFromController()));
    }

    @Test
    public void testGetNumberOfAttempts(){
        testComparing_1_and_1();
        Assert.assertEquals(controller.getNumberOfAttempts(), attempts);
    }

    @Test
    public void testStatistic_0_and_1(){
        testComparing_0_and_1();
        Assert.assertEquals("greater than 0 ", controller.getStatistic());
    }

    @Test
    public void testStatistic_101_and_0(){
        testComparing_101_and_0();
        Assert.assertEquals("lesser than 101 ", controller.getStatistic());
    }

    private void testComparing_101_and_0() {
        Assert.assertEquals("lesser", compareNumbersForTest(101,0));
    }

    public String compareNumbersForTest(int firstNumber, int secondNumber){
        attempts++;
        return controller.compareNumbers(firstNumber, secondNumber);
    }

    public int getRandomNumberFromController(){
        return controller.getRandomNumberBetween_100_0();
    }

}
