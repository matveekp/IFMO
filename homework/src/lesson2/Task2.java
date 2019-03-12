package lesson2;

public class Task2 {
    public static void main(String[] args) {

//        Задача 2
//        Создайте программу, выводящую на экран все неотрицательные элементы последовательности 90 85 80 75 70 65 60 ….

        int i = 90;

        while (i>0) {
            System.out.print(i + " ");
            i-=5;
        }
    }
}
