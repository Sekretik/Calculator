package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        try {
            System.out.println(calculator.calculate(expression));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
