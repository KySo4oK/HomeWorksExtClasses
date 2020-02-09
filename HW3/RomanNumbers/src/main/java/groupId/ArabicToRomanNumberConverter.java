package groupId;

public class ArabicToRomanNumberConverter {
    public String Convert(int arabicNumber) {
        boolean noNumber = arabicNumber == 0;
        if (noNumber)
            return getDefaultString();
        if (arabicNumber == 2)
            return "II";
        else return "I";
    }

    private String getDefaultString() {
        return "";
    }
}
