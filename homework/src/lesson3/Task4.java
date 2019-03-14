package lesson3;

import java.util.Scanner;

public class Task4 {

//    Задача 4
//    Пользователь должен указать с клавиатуры чётное положительное число, а программа должна создать массив указанного размера из случайных целых чисел из [-5;5] и вывести его на экран в строку.
//    После этого программа должна определить и сообщить пользователю о том, сумма модулей какой половины массива больше:
//    левой или правой, либо сообщить, что эти суммы модулей равны. Если пользователь введёт неподходящее число,
//    то программа должна требовать повторного ввода до тех пор, пока не будет указано корректное значение.

    public static void main(String[] args) {

        int size;
        int sum1 = 0;
        int sum2 = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите чётное положительное число");

        while (true) {

                size = scanner.nextInt();

                if (size % 2 != 0 || size <= 0) {
                    System.out.println("Вы ввели неподходящее число, повторите ввод");
                }
                else break;

        }

        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {

            array[i] = ((int) (Math.random()*11))-5;
//            System.out.print(array[i]+" ");  //вывод массива для проверки
        }

        for (int i = 0; i < array.length/2; i++) {
            sum1 += Math.abs(array[i]);
        }

        for (int i = array.length/2; i < array.length; i++) {
            sum2 += Math.abs(array[i]);
        }

//        System.out.println();
//        System.out.println("sum1 is " + sum1 + ", sum2 is " + sum2); //вывод сумм для проверки

        System.out.println(sum1 == sum2 ? "сумма модулей равна" : sum1 > sum2 ? "сумма модулей первой половины больше второй" : "сумма модулей второй половины больше первой");

    }

}
