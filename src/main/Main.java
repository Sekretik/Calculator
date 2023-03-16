package main;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String expression = "1 - 2";

        try {
            System.out.println(calculator.calculate(expression));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
