package lesson3;

import java.util.Scanner;

public class Task6 {

//    2) Требуется удалить из нее повторяющиеся символы и все пробелы .
//            Например, если было введено " abc cde def egh ", то должно быть выведено "abcdef".

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку");
        String string = scanner.nextLine().replaceAll("\\s", "");

        StringBuilder sb = new StringBuilder(string);

        for (int i = 0; i < sb.length()-1 ; i++) {

            char ch = sb.charAt(i);
            for (int j = i+1; j < sb.length(); j++) {
                    if (ch == sb.charAt(j))
                        sb.deleteCharAt(j);

            }

        }

        System.out.println(sb);





    }


}
