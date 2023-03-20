package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(calculator.calculate(scanner.nextLine()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
