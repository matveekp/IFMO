package lesson3;

public class Task1 {

//    Задача 1
//    Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран сначала в строку,
//    отделяя один элемент от другого пробелом, а затем в столбик (отделяя один элемент от другого началом новой строки).
//    Перед созданием массива подумайте, какого он будет размера. 2 4 6 … 18 20 2 4 6 … 20

    public static void main(String[] args) {

        int[] array = new int[10];

        for (int i = 0; i < array.length ; i++) {
            array[i] = (i+1)*2;

            System.out.print(array[i] + " ");
        }


        System.out.println();

        for (int i : array) {
            System.out.println(i);
        }

    }

}
