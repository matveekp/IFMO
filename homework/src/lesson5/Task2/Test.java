package lesson5.Task2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        int x;
        int y;

        Calculator calculator;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число 1");
        x = scanner.nextInt();

        System.out.println("Введите число 2");
        y = scanner.nextInt();

        System.out.println("Укажите желаемое действие: + - * / ");


        switch (scanner.next()) {

           case "+":
               calculator = new Calculator(new Addition());
               System.out.println(calculator.execute(x, y));
               break;

           case "-":
               calculator = new Calculator(new Subtraction());
               System.out.println(calculator.execute(x, y));
               break;

           case "*":
               calculator = new Calculator(new Multiplication());
               System.out.println(calculator.execute(x,y));
               break;

           case "/":
               calculator = new Calculator(new Division());
               System.out.println(calculator.execute(x,y));
               break;

           default:
               System.out.println("ERROR");
               break;


       }


    }

}
