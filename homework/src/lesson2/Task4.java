package lesson2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task4 {

//    Задача 4
//    Проверьте, является ли натуральное число — простым.
    public static void main(String[] args) {

        int i=0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");

        try {
            i=scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Вы ввели не число");
            return;
        }

        if (i <= 0 ) {
            System.out.println("Вы ввели не натуральное число");
            return;
        }


        if ( i % 2 == 0)
            System.out.println("Число составное");
        else
            System.out.println("Число простое");



    }
}
