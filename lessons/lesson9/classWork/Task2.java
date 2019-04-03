//package lesson9.classWork;
//
////Задача 2
//////        Написать программу со следующим функционалом:
//////        Считывание 20 чисел с клавиатуры,
//////        сохранение их в список,
//////        сортировка по трём другим спискам:
//////        число нацело делится на 3,
//////        нацело делится на 2 и
//////        все остальные.
//////        Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
//////        Метод printList() должен выводить на экран все элементы всех списков с новой строки.
//////        Метод printList(String listName) должен выводить на экран все элементы указанного списка
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Task2 {
//
//    List<Integer> list1;
//
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < 20; i++) {
//            list.add(scanner.nextInt());
//        }
//
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        List<Integer> list3 = new ArrayList<>();
//
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) %2 == 0 && list.get(i) % 3 == 0) {
//                list1.add(list.get(i));
//                list2.add(list.get(i))
//
//            }
//
//            else if (list.get(i) % 2 ==0)
//                list1.add(list.get(i));
//            else if (list.get(i) % 3 == 0)
//                list2.add(list.get(i));
//            else list3.add(list.get(i));
//
//        }
//
//
//    }
//
//    public void printAllLists(){
//        System.out.println();
//    }
//
//    public void printList(List<Integer> list){
//        System.out.println(list);
//
//
//    }
//
//
//
//}
