package groupId;

import java.util.AbstractMap;
import java.util.ArrayList;

public class ArabicToRomanNumberConverter {
    private ArrayList<AbstractMap.SimpleEntry<Integer, String>> map;

    public ArabicToRomanNumberConverter() {
        map = new ArrayList<>();
        map.add(new AbstractMap.SimpleEntry<>(5, "V"));
        map.add(new AbstractMap.SimpleEntry<>(1, "I"));
    }

    public String Convert(int arabicNumber) {
        boolean noNumber = arabicNumber == 0;
        if (noNumber)
            return getDefaultString();
        return getRepeatingRomanNumber(arabicNumber);
    }

    private String getRepeatingRomanNumber(int arabicNumber) {
        String romanNumber = "";

        for (AbstractMap.SimpleEntry<Integer, String> digit : map) {
            while (arabicNumber >= digit.getKey()) {
                romanNumber += digit.getValue();
                arabicNumber -= digit.getKey();
            }
        }


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
