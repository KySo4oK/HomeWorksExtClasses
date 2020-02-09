package groupId;

import org.junit.Assert;
import org.junit.Test;

public class WhenConvertArabicNumberToRoman {
    @Test
    public void Convert_0_To_EmptyString(){
        String romanNumber = convertToRoman(0);
        Assert.assertEquals("", romanNumber);
    }

    private String convertToRoman(int arabicNumber) {
        ArabicToRomanNumberConverter converter = new ArabicToRomanNumberConverter();
        return converter.Convert(arabicNumber);
    }

    @Test
    public void Convert_1_To_I(){
        String romanNumber = convertToRoman(1);
        Assert.assertEquals("I", romanNumber);
    }

    @Test
    public void Convert_2_To_II(){
        String romanNumber = convertToRoman(2);
        Assert.assertEquals("II", romanNumber);
    }
}
