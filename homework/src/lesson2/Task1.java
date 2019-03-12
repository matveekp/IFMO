package lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

//    Задача 1*
//    В три переменные a, b и c явно записаны программистом три целых попарно неравных между собой числа.
//    Создать программу, которая переставит числа в переменных таким образом, чтобы при выводе на
//    экран последовательность a, b и c оказалась строго возрастающей.

    public static void main(String[] args) {

    int a = 5;
    int b = -2;
    int c = 9;

    int[] array = {a,b,c};
    Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }


    }

}
