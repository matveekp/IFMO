package lesson11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
//    Задача 4
//    Посчитать в файле количество символов , (запятая). Количество вывести в консоль.

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите имя файла для подсчета запятых");

        try (BufferedReader input = new BufferedReader(new FileReader(reader.readLine()))) {
            long count = 0;


            while (input.ready()) {

                if (input.read() == ',')
                    count++;
            }

            System.out.println(count);
        }
    }
}
