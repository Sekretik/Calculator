package main;

import java.util.List;

public class Converter {
    /*
            Два метода по конвертации украдены из интернета, но разобраны и поняты
     */

    public static int convertToArabic(String number){
        String romanNumeral = number.toUpperCase();
        int result = 0;

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(number + " не Являеться валидной строкой");
        }

        return result;
    }

    public static String convertToRoman(int number){
        if ((number <= 0)) {
            throw new IllegalArgumentException(number + " меньше чем 1");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public static boolean isRoman(String number){
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            return false;
        }

        return true;
    }
}
