package lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

//    Задача 1*
//    В три переменные a, b и c явно записаны программистом три целых попарно неравных между собой числа.
//    Создать программу, которая переставит числа в переменных таким образом, чтобы при выводе на
//    экран последовательность a, b и c оказалась строго возрастающей.

    public static void main(String[] args) {

    int a,b,c;

    Scanner scanner = new Scanner(System.in);

    System.out.println("Введите 3 числа через пробел");
    String[] list = scanner.nextLine().split(" ");

    int[] array = new int[list.length];

        for (int i = 0; i < array.length ; i++) {
            array[i] = Integer.parseInt(list[i]);
        }

    Arrays.sort(array);



        for (int i : array) {
            System.out.print(i + " ");
        }



    }

}
