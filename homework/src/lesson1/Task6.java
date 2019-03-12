package lesson1;

public class Task6 {
//    Задача 6:
//    Создать программу, выводящую в консоль наибольшую цифру любого трехзначного натурального числа. Примеры работы программы:
//    В числе 208 наибольшая цифра 8
//    В числе 774 наибольшая цифра 7
//    В числе 613 наибольшая цифра 6

    public static void main(String[] args) {

//        int x = 613;

        int x = (int) (Math.random()*(999-100));

        int a = x % 10;
        int b = x / 10 % 10;
        int c = x / 100 % 10;

        int max = a > b && a > c ? a : b > c && b > a ? b : c;


        System.out.println(String.format("В числе %d наибольшая цифра %d", x, max));


        

    }
}
