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
        romanNumber = getRemovedThroughOneRepeating(romanNumber);
        romanNumber = getRemovedThroughTwoRepeating(romanNumber);
        return romanNumber;
    }

    private String getRemovedThroughTwoRepeating(String romanNumber) {
        for (int i = 4; i < romanNumber.length(); i++) {
            if (checkForThroughTwoEqualsPartOfRomanNumber(romanNumber, i)) {
                System.out.println(romanNumber);
                romanNumber = getRemovedThroughTwoEqualsPartOfRomanNumber(romanNumber, i);
                i = 4;
            }
        }
        return romanNumber;
    }

    private String getRemovedThroughTwoEqualsPartOfRomanNumber(String romanNumber, int index) {
        return romanNumber.substring(0, index - 3) +
                romanNumber.substring(index - 1, index + 1) +
                getNext(romanNumber.substring(index - 2, index - 1));
    }

    private boolean checkForThroughTwoEqualsPartOfRomanNumber(String romanNumber, int index) {
        return (romanNumber.charAt(index - 3) == romanNumber.charAt(index) &&
                map.indexOf(romanNumber.substring(index - 1, index)) >
                        map.indexOf(romanNumber.substring(index - 3, index - 2)));
    }

    private String getRemovedThroughOneRepeating(String romanNumber) {
        for (int i = 2; i < romanNumber.length(); i++) {
            if (checkForThroughOneEqualsPartOfRomanNumber(romanNumber, i)) {
                System.out.println(romanNumber);
                romanNumber = getRemovedThroughOneEqualsPartOfRomanNumber(romanNumber, i);
                i = 2;
            }
        }
        return romanNumber;
    }

    private String getRemovedThroughOneEqualsPartOfRomanNumber(String romanNumber, int index) {
        int lengthOfRomanNumber = romanNumber.length();
        return romanNumber.substring(0, index - 2) +
                romanNumber.substring(index - 1, index) +
                getNext(romanNumber.substring(index - 2, index - 1)) +
                romanNumber.substring(index + 1, lengthOfRomanNumber);
    }

    private boolean checkForThroughOneEqualsPartOfRomanNumber(String romanNumber, int index) {
        return (romanNumber.charAt(index - 2) == romanNumber.charAt(index) &&
                romanNumber.substring(index - 2, index - 1).equals(getNext(romanNumber.substring(index - 1, index))));
    }

    private String getRemovedNearRepeating(String romanNumber) {
        for (int i = 3; i < romanNumber.length(); i++) {
            if (checkForEqualsPartOfRomanNumber(romanNumber, i)) {
                romanNumber = getRemovedNearEqualsPartOfRomanNumber(romanNumber, i);
                i = 3;
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