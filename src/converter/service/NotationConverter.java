package converter.service;

import converter.exception.InvalidValueException;

import java.util.ArrayList;
import java.util.List;

public class NotationConverter {
    public int toArabic(String romanNotation) throws InvalidValueException {
        List<Integer> arabicIntegers = convertToListOfArabic(romanNotation);
        int result = 0;
        for (int i = 0; i < arabicIntegers.size(); i++) {
            if (i + 1 == arabicIntegers.size()) {
                result += arabicIntegers.get(arabicIntegers.size() - 1);
                break;
            }
            if (arabicIntegers.get(i) < arabicIntegers.get(i + 1)) {
                result -= arabicIntegers.get(i);
            } else
                result += arabicIntegers.get(i);
        }
        return result;
    }

    private List<Integer> convertToListOfArabic(String romanNotation) {
        if (romanNotation == null || romanNotation.equals("")) {
            throw new InvalidValueException();
        }
        char[] romanChars = romanNotation.toCharArray();
        List<Integer> arabicNumbers = new ArrayList<>();
        for (char romanChar : romanChars) {
            arabicNumbers.add(getArabicFromRomanChar(romanChar));
        }
        return arabicNumbers;
    }

    private Integer getArabicFromRomanChar(char romanChar) {
        Integer integer = switch (romanChar) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> null;
        };
        if (integer == null) {
            throw new InvalidValueException();
        }
        return integer;
    }
}
