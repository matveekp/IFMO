package lesson3;


import java.util.Arrays;
import java.util.Scanner;

public class Task7 {

//    3) Вводится строка, содержащая буквы, целые неотрицательные числа и иные символы.
//    Требуется все числа, которые встречаются в строке, поместить в отдельный целочисленный массив.
//    Например, если дана строка "дом 48, корпус 9, парадная 7, этаж 4 квартира 88 домофон 9876  ", то в массиве должны оказаться числа 48, 9, 7 и 4

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку, содержащую буквы, целые неотрицательные числа и иные символы ");

        //  дом 48, корпус 9, парадная 7, этаж 4 квартира 88 домофон 9876


        String[] strings = scanner.nextLine().replaceAll("\\D+", " ").trim().split(" ");

        int[] array = new int[strings.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
            }

        System.out.println(Arrays.toString(array));



    }

}
