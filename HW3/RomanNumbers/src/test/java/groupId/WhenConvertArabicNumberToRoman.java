package groupId;

import org.junit.Assert;
import org.junit.Test;

public class WhenConvertArabicNumberToRoman {
    @Test
    public void Convert_0_To_EmptyString(){
        ArabicToRomanNumberConverter converter = new ArabicToRomanNumberConverter();
        String romanNumber = converter.Convert(0);
        Assert.assertEquals("", romanNumber);
    }
}
