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
        String romanNumber = getRoughRomanNumber(arabicNumber);
        int lengthOfRoughRomanNumber = romanNumber.length();
        for (int i = 3; i < lengthOfRoughRomanNumber; i++) {
            if (romanNumber.charAt(i - 3) == romanNumber.charAt(i - 2) &&
                    romanNumber.charAt(i - 2) == romanNumber.charAt(i - 1) &&
                    romanNumber.charAt(i - 1) == romanNumber.charAt(i)) {
                romanNumber = romanNumber.substring(0, i - 2) +
                        getNext(romanNumber.substring(i - 3, i - 2)) +
                        romanNumber.substring(i+1, lengthOfRoughRomanNumber);
            }
        }
        return romanNumber;
    }

    private String getNext(String partOfRoman) {
        for (int i = 0; i < map.size(); i++) {
            AbstractMap.SimpleEntry digit = map.get(i);
            if (digit.getValue().equals(partOfRoman)) {
                return map.get(i - 1).getValue();
            }
        }
        return "";
    }

    private String getRoughRomanNumber(int arabicNumber) {
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
