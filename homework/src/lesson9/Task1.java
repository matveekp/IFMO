package lesson9;

import java.util.*;

public class Task1 {

    List<String> list;
    Scanner scanner;

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.run();
    }

    public void run() {
        list = new ArrayList<>();
        scanner = new Scanner(System.in);

        for (int i = 0; i < 5 ; i++) {
            list.add(scanner.next());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o1.length() == o2.length() ? 0 : o1.length() > o2.length() ? 1 : -1 ;
            }
        });

        int minLength = list.get(0).length();

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).length() == minLength)
                System.out.println(list.get(i));
            else
                break;

        }




    }



}
