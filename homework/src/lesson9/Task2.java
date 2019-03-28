package lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Task2 {

        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.run();


    }


    public void run(){


        for (int i = 0; i < 20; i++) {
            list.add(scanner.nextInt());
        }

        for (int i = 0; i < list.size() ; i++) {
            if (list.get(i) % 2 == 0)
                list1.add(list.get(i));
            if (list.get(i) % 3 == 0)
                list2.add(list.get(i));
            if (list.get(i) % 2 != 0 && list.get(i) % 3 != 0)
                list3.add(list.get(i));
        }

        printList();

        System.out.println("---------");

        printList(list1);

    }

    public void printList(){

        System.out.println(list);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

    }

    public void printList(List<Integer> list){

        System.out.println(list);
    }





}
