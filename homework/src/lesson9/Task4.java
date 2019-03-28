package lesson9;

import java.util.*;

public class Task4 {

    List<String> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Task4 task4 = new Task4();
        task4.run();
    }

    public void run(){

        for (int i = 0; i < 5; i++) {
            list.add(scanner.next());
        }

        list.remove(3);
        System.out.println(list);
        System.out.println("------");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });

        System.out.println(list);





    }


}
