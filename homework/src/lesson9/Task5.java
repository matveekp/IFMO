package lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5 {


    List<String> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Task5 task5 = new Task5();
        task5.run();
    }


    public void run() {
        for (int i = 0; i < 10; i++) {
            list.add(scanner.next());

        }

        System.out.println(isSorted(list));

    }


    public boolean isSorted(List<String> list) {

        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i).length() < list.get(i + 1).length()) {

            } else {
                System.out.println(i+1);
                System.out.println(list.get(i + 1));
                return false;




            }

        }
        return true;
    }

}

