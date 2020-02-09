package groupId;

public class ArabicToRomanNumberConverter {
    public String Convert(int arabicNumber) {
        boolean noNumber = arabicNumber == 0;
        if (noNumber)
            return getDefaultString();
        return getRepeatingRomanNumber(arabicNumber);
    }

    private String getRepeatingRomanNumber(int arabicNumber) {
        String romanNumber = "";

        while (arabicNumber >= 5) {
            romanNumber += "V";
            arabicNumber -= 5;
        }

        while (arabicNumber >= 1) {
            romanNumber += "I";
            arabicNumber -= 1;
        }
        return romanNumber;
    }

    private String getDefaultString() {
        return "";
    }
}
