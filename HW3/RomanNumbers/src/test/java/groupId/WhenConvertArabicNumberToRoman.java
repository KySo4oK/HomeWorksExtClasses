package groupId;

import org.junit.Assert;
import org.junit.Test;

public class WhenConvertArabicNumberToRoman {
    @Test
    public void Convert_0_To_EmptyString() {
        String romanNumber = convertToRoman(0);
        Assert.assertEquals("", romanNumber);
    }

    private String convertToRoman(int arabicNumber) {
        ArabicToRomanNumberConverter converter = new ArabicToRomanNumberConverter();
        return converter.Convert(arabicNumber);
    }

    @Test
    public void Convert_1_To_I() {
        String romanNumber = convertToRoman(1);
        Assert.assertEquals("I", romanNumber);
    }

    @Test
    public void Convert_2_To_II() {
        String romanNumber = convertToRoman(2);
        Assert.assertEquals("II", romanNumber);
    }

    @Test
    public void Convert_3_To_III() {
        String romanNumber = convertToRoman(3);
        Assert.assertEquals("III", romanNumber);
    }

    @Test
    public void Convert_5_To_V() {
        String romanNumber = convertToRoman(5);
        Assert.assertEquals("V", romanNumber);
    }

    @Test
    public void Convert_6_To_VI() {
        String romanNumber = convertToRoman(6);
        Assert.assertEquals("VI", romanNumber);
    }

    @Test
    public void Convert_8_To_VIII() {
        String romanNumber = convertToRoman(8);
        Assert.assertEquals("VIII", romanNumber);
    }

    @Test
    public void Convert_4_To_IV() {
        String romanNumber = convertToRoman(4);
        Assert.assertEquals("IV", romanNumber);
    }

    @Test
    public void Convert_9_To_IX() {
        String romanNumber = convertToRoman(9);
        Assert.assertEquals("IX", romanNumber);
    }

    @Test
    public void Convert_10_To_X() {
        String romanNumber = convertToRoman(10);
        Assert.assertEquals("X", romanNumber);
    }

    @Test
    public void Convert_11_To_XI() {
        String romanNumber = convertToRoman(11);
        Assert.assertEquals("XI", romanNumber);
    }

    @Test
    public void Convert_14_To_XIV() {
        String romanNumber = convertToRoman(14);
        Assert.assertEquals("XIV", romanNumber);
    }

    @Test
    public void Convert_15_To_XV() {
        String romanNumber = convertToRoman(15);
        Assert.assertEquals("XV", romanNumber);
    }

    @Test
    public void Convert_19_To_XIX() {
        String romanNumber = convertToRoman(19);
        Assert.assertEquals("XIX", romanNumber);
    }

    @Test
    public void Convert_100_To_C() {
        String romanNumber = convertToRoman(100);
        Assert.assertEquals("C", romanNumber);
    }

    @Test
    public void Convert_99_To_IC() {
        String romanNumber = convertToRoman(99);
        Assert.assertEquals("IC", romanNumber);
    }
}
