package lesson5.Task1;


//        Задание 1
//        Изменить (реализовать) связный список следующим образом :
//        Список используется для хранения данных типа Object ( класс в Java от которого наследуются все классы).
//        Создать интерфейсы: Stack, Queue и List, для каждого определить методы, соответствующие этим структурам данных.
//        Список должен реализовать эти интерфейсы и соответствующие методы.

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        MyList myList = new MyList();



        myList.add(4);
        myList.add(2);
        myList.add(9);
        myList.add(11);

        System.out.println(myList);

        System.out.println(myList.get(3));
        myList.remove(1);
        System.out.println(myList);

        System.out.println("-----------------------------------");

        MyList myQueueList = new MyList();

        myQueueList.enqueue(5);
        myQueueList.enqueue(3);
        myQueueList.enqueue(2);
        myQueueList.enqueue(4);

        System.out.println(myQueueList);
        System.out.println("Забираем первый элемент из очереди = " + myQueueList.dequeu());
        System.out.println(myQueueList);

        System.out.println("-----------------------------------");

        MyList myStackList = new MyList();

        myStackList.push(4);
        myStackList.push(8);
        myStackList.push(2);
        myStackList.push(1);

        System.out.println(myStackList);
        System.out.println("Забираем последний элемент из стека = " + myStackList.pop());
        System.out.println(myStackList);

    }


}
