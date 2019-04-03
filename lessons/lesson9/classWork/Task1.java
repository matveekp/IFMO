package lesson9.classWork;

//Задача 1
////        Написать программу со следующим функционалом:
////        Считывание максимум 5 строк с клавиатуры,
////        занесение строк в список,
////        поиск самой короткой строки,
////        вывод самой короткой строки на экран по запросу пользователя (команда в консоле /short string)
////        Если одинаково коротких строк несколько, выводить каждую с новой строки.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task1 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        int min=Integer.MAX_VALUE;
        int x;

        for (int i = 0; i < 5 ; i++) {
            stringList.add(scanner.next());
        }



        for (int i = 0; i < stringList.size(); i++) {

            if (stringList.get(i).length() < min)
                min = stringList.get(i).length();
                    }

        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).length() == min)
                System.out.println(stringList.get(i));
        }






    }


}
