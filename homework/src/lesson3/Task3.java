package lesson3;

public class Task3 {

//    Задача 3
//    Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
//    Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на отдельной строке.

    public static void main(String[] args) {

        int count=0;
        int[] array = new int[15];

        for (int i = 0; i < array.length; i++) {

            array[i] = (int) (Math.random()*10);

            if ( array[i] % 2 == 0 && array[i] != 0)
                count++;

        }

        System.out.println(count);

    }
}
