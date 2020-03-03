package extclasses;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testGetAverageWithAverageFunc() {
        App app = new App();
        double result = app.getAverageWithAverageFunc(new int[]{3, 4, 5});
        assertEquals(result, 4.0);
    }

    @Test
    public void testGetAverageWithoutAverageFunc() {
        App app = new App();
        double result = app.getAverageWithoutAverageFunc(new int[]{3, 4, 5});
        assertEquals(result, 4.0);
    }

    @Ignore
    @Test
    public void testGetMinValueWithIndex() {
        App app = new App();
        int[] result = app.getMinValueWithIndex(new int[]{3, 4, 5});
        assertTrue((result[0] == 0) && (result[1] == 3));
    }

    @Test
    public void testCountEqualsZero() {
        App app = new App();
        long result = app.countEqualsZero(new int[]{0, 0, 0, 0, 3, 0, 4, 5});
        assertEquals(result, 5);
    }

    @Test
    public void testCountMoreThanZero() {
        App app = new App();
        long result = app.countMoreThanZero(new int[]{0, 0, 0, 0, 3, 0, 4, 5});
        assertEquals(result, 3);
    }

    @Test
    public void testMultiplyWithNumber() {
        App app = new App();
        int[] ints = {0,0,3,4,4,4,5,6,7};
        int number = 123;
        int[] result = app.multiplyWithNumber(ints, number);
        for (int i = 0; i < result.length; i++) {
            if (result[i] != ints[i]*number) {
                Assert.fail();
            }
        }
    }


}
