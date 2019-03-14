package lesson2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task4 {

//    Задача 4
//    Проверьте, является ли натуральное число — простым.
    public static void main(String[] args) {

        int number=0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");

        try {
            number=scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Вы ввели не число");
            return;
        }

        if (number <= 0 ) {
            System.out.println("Вы ввели не натуральное число");
            return;
        }

        if (number==1){
        System.out.println("Число составное");
        return; }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                System.out.println("Число составное");
                return;
            }
        }

        System.out.println("Число простое");

    }
}
