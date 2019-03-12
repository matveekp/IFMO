package lesson2;

public class Task3 {

//    Задача 3*
//    Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8 16 32 64 128 ….

    public static void main(String[] args) {

        int x = 1;

        for (int i = 0; i < 20 ; i++) {

            x = x*2;
            System.out.print(x + " ");

        }



    }
}
