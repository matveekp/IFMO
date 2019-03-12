package lesson1;

public class Task4 {
    public static void main(String[] args) {
//        Задача 4:
//        Вывести в консоль ближайшее к 10 из двух чисел, записанных в переменные m и n.
//                Например, среди чисел 8.5 и 11.45 ближайшее к десяти 11.45.
//                Метод Math.abs(n) возвращает абсолютное значение числа (модуль числа).


            double m = 8.5;
            double n = 11.45;
            double target = 10;

            System.out.println(findNear(m, n, target));



    }

    public static double findNear ( double m, double n, double target) {

        return  ((Math.abs(target - m)) < Math.abs(target - n)) ? m : n;


        
    }


}
