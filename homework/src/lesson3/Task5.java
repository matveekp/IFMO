package lesson3;

import java.util.Scanner;

public class Task5 {

//    1) Найти в строке указанную подстроку и заменить ее на новую.
//    Строку, ее подстроку для замены и новую подстроку вводит пользователь.

    public static void main(String[] args) {

        String string;
        String findString;
        String changeString;
        String newString;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку");
        string = scanner.nextLine();
//        string = "Строку, ее подстроку для замены и новую подстроку вводит пользователь."; //отладка

        System.out.println("Введите подстроку, которую нужно заменить");
        findString = scanner.nextLine();

        System.out.println("Введите новую подстроку");
        changeString = scanner.nextLine();

        newString = string.replace(findString, changeString);

        System.out.println(newString);

    }
}
