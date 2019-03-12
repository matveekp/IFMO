package lesson2;

public class Task5 {

//    Задача 5
//    Выведите на экран первые 11 членов последовательности Фибоначчи. Первый и второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих.

    public static void main(String[] args) {

        int[] fibo = new int[11];

        fibo[0] = 1;
        fibo[1] = 1;

        System.out.print(fibo[0] + " " + fibo[1] + " ");


        for (int i = 2; i < fibo.length; i++) {
            fibo[i] = fibo [i - 1] + fibo [i - 2];
            System.out.print(fibo[i] + " ");
        }


    }
}
