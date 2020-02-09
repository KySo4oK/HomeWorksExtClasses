package groupId;

public class ArabicToRomanNumberConverter {
    public String Convert(int arabicNumber) {
        boolean noNumber = arabicNumber == 0;
        if (noNumber)
            return getDefaultString();
        String romanNumber = "";
        while (arabicNumber >= 1) {
            romanNumber += "I";
            arabicNumber--;
        }
        return romanNumber;
    }

    private String getDefaultString() {
        return "";
    }
}
