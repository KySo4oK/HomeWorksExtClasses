package groupId;

import java.util.AbstractMap;
import java.util.ArrayList;

public class ArabicToRomanNumberConverter {
    private ArrayList<AbstractMap.SimpleEntry<Integer, String>> map;

    public ArabicToRomanNumberConverter() {
        map = new ArrayList<>();
        map.add(new AbstractMap.SimpleEntry<>(1000, "M"));
        map.add(new AbstractMap.SimpleEntry<>(500, "D"));
        map.add(new AbstractMap.SimpleEntry<>(100, "C"));
        map.add(new AbstractMap.SimpleEntry<>(50, "L"));
        map.add(new AbstractMap.SimpleEntry<>(10, "X"));
        map.add(new AbstractMap.SimpleEntry<>(5, "V"));
        map.add(new AbstractMap.SimpleEntry<>(1, "I"));
    }

    public String Convert(int arabicNumber) {
        if (arabicNumber == 0)
            return getDefaultString();
        return changeToRoughAndRemoveAllRepeating(arabicNumber);
    }

    private String changeToRoughAndRemoveAllRepeating(int arabicNumber) {
        String romanNumber = getRoughRomanNumber(arabicNumber);
        romanNumber = getRemovedNearRepeating(romanNumber);
        romanNumber = getRemovedNotNearRepeating(romanNumber);
        return romanNumber;
    }

    private String getRemovedNotNearRepeating(String romanNumber) {
        for (int i = 2; i < romanNumber.length(); i++) {
            if (checkForNotNearEqualsPartOfRomanNumber(romanNumber, i)) {
                romanNumber = getRemovedNotNearEqualsPartOfRomanNumber(romanNumber, i);
                i = i - 1;
            }
        }
        return romanNumber;
    }

    private String getRemovedNotNearEqualsPartOfRomanNumber(String romanNumber, int index) {
        return romanNumber.substring(0, index - 2) +
                romanNumber.substring(index - 1, index) +
                getNext(romanNumber.substring(index - 2, index - 1));
    }

    private boolean checkForNotNearEqualsPartOfRomanNumber(String romanNumber, int index) {
        return (romanNumber.charAt(index - 2) == romanNumber.charAt(index) &&
                romanNumber.substring(index - 2, index - 1).equals(getNext(romanNumber.substring(index - 1, index))));
    }

    private String getRemovedNearRepeating(String romanNumber) {
        for (int i = 3; i < romanNumber.length(); i++) {
            if (checkForEqualsPartOfRomanNumber(romanNumber, i)) {
                romanNumber = getRemovedNearEqualsPartOfRomanNumber(romanNumber, i);
                i = i - 2;
            }
        }
        return romanNumber;
    }

    private boolean checkForEqualsPartOfRomanNumber(String romanNumber, int index) {
        return (romanNumber.charAt(index - 3) == romanNumber.charAt(index - 2) &&
                romanNumber.charAt(index - 2) == romanNumber.charAt(index - 1) &&
                romanNumber.charAt(index - 1) == romanNumber.charAt(index));
    }

    private String getRemovedNearEqualsPartOfRomanNumber(String romanNumber, int index) {
        int lengthOfRoughRomanNumber = romanNumber.length();
        return romanNumber.substring(0, index - 2) +
                getNext(romanNumber.substring(index - 3, index - 2)) +
                romanNumber.substring(index + 1, lengthOfRoughRomanNumber);

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