package main;

public class Calculator {
    public String calculate(String expression) throws Exception {
        if(expression.contains("\n")) throw new Exception("Выражение должно быть записано в одну строку");
        if(expression.contains(".") || expression.contains(",")) throw new Exception("Выражение должно содержать только целые числа");

        expression = expression.replaceAll(" ", "");

        String symbol = "";
        String number1 = "";
        String number2 = "";

        for (int i = 0; i < expression.length(); i++) {
            try {
                switch (expression.charAt(i)) {
                    case '+':
                    case '-':
                    case '/':
                    case '*':
                        if(symbol != "") throw new Exception("В выражении не должно быть двух знаков");
                        symbol = String.valueOf(expression.charAt(i));
                        number1 = expression.substring(0, i);
                        number2 = expression.substring(i + 1);
                }
            }catch (StringIndexOutOfBoundsException e){
                throw new Exception("Нет знака");
            }
        }

        if(number1 == "" || number2 == "")
            throw new Exception("Строка не является математической операцией");

        if (Converter.isRoman(number1) != Converter.isRoman(number2))
            throw new Exception("Числа используют разные системы счисления или содержат лишние символы");

        int n1;
        int n2;

        NumeralSystem numeralSystem;

        try {
            n1 = Integer.parseInt(number1);
            n2 = Integer.parseInt(number2);
            numeralSystem = NumeralSystem.Arabic;
        } catch (NumberFormatException e) {
            n1 = Converter.convertToArabic(number1);
            n2 = Converter.convertToArabic(number2);
            numeralSystem = NumeralSystem.Roman;
        }

        if(n1 < 1 || n1 > 10 || n2 < 1 || n2 > 10)
            throw new Exception("Числа должны быть не меншье 1 и не больше 10");

        Integer result = null;

        switch (symbol){
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "/":
                result = n1 / n2;
                break;
            case "*":
                result  = n1 * n2;
                break;
        }

        switch (numeralSystem) {
            case Arabic:
                return String.valueOf(result);
            case Roman:
                return Converter.convertToRoman(result);
        }
        return "";
    }
}
